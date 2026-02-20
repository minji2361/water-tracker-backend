package com.yeoul.waterapp.service;

import com.yeoul.waterapp.domain.User;
import com.yeoul.waterapp.dto.UserGoalResponse;
import com.yeoul.waterapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;

@Service
public class UserGoalService {

    private final UserRepository userRepository;
    private static final int ML_PER_KG = 30;

    public UserGoalService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserGoalResponse getGoal(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        int age = calcAge(user.getBirthDate());
        String gender = normalizeGender(user.getGender());

        int baseMl = calcBaseMl(age, gender);
        Double weightKg = user.getWeight();
        int weightBasedMl = calcWeightBasedMl(weightKg);

        GoalResult mixed = mixGoal(age, baseMl, weightBasedMl);

        UserGoalResponse response = new UserGoalResponse();
        response.setUserId(user.getId());
        response.setAge(age);
        response.setGender(gender);
        response.setWeightKg(weightKg);
        response.setBaseMl(baseMl);
        response.setWeightBasedMl(weightBasedMl);
        response.setGoalMl(mixed.getGoalMl());
        response.setRule(mixed.getRule());

        return response;
    }

    private int calcAge(String birthDate) {
        try {
            LocalDate birth = LocalDate.parse(birthDate);
            LocalDate today = LocalDate.now();
            int years = Period.between(birth, today).getYears();
            if (years < 0) throw new IllegalArgumentException("birthDate is in the future");
            return years;
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("birthDate must be yyyy-MM-dd");
        }
    }

    private String normalizeGender(String genderRaw) {
        String gender = genderRaw == null ? "" : genderRaw.trim().toUpperCase();
        if (!gender.equals("MALE") && !gender.equals("FEMALE")) {
            throw new IllegalArgumentException("gender must be MALE or FEMALE");
        }
        return gender;
    }

    private int calcBaseMl(int age, String gender) {
        if (age <= 12) return 1200;
        if (age <= 17) return 1800;

        int base = gender.equals("MALE") ? 2500 : 2000;
        if (age >= 65) return Math.max(base - 300, 1200);
        return base;
    }

    private int calcWeightBasedMl(Double weightKg) {
        if (weightKg == null) return 0;
        if (weightKg <= 0) throw new IllegalArgumentException("weight must be > 0");
        return (int) Math.round(weightKg * ML_PER_KG);
    }

    private GoalResult mixGoal(int age, int baseMl, int weightBasedMl) {
        if (age <= 17) {
            return new GoalResult(baseMl, "MINOR_BASE_ONLY");
        }

        int mixed = baseMl;
        String rule = "ADULT_BASE_ONLY";

        if (weightBasedMl > 0) {
            mixed = Math.max(baseMl, weightBasedMl);
            rule = (mixed == weightBasedMl) ? "ADULT_MAX_WEIGHT_BASED" : "ADULT_MAX_BASE";
        }

        mixed = clamp(mixed, 1500, 4000);
        rule = rule + "_CLAMP_1500_4000";

        return new GoalResult(mixed, rule);
    }

    private int clamp(int value, int min, int max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }

    private static class GoalResult {
        private final int goalMl;
        private final String rule;

        private GoalResult(int goalMl, String rule) {
            this.goalMl = goalMl;
            this.rule = rule;
        }

        public int getGoalMl() {
            return goalMl;
        }

        public String getRule() {
            return rule;
        }
    }
}