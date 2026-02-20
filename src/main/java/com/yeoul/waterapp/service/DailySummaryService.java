package com.yeoul.waterapp.service;

import com.yeoul.waterapp.domain.DrinkLog;
import com.yeoul.waterapp.dto.DailySummaryResponse;
import com.yeoul.waterapp.dto.UserGoalResponse;
import com.yeoul.waterapp.repository.DrinkLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DailySummaryService {

    private final DrinkLogRepository drinkLogRepository;
    private final UserGoalService userGoalService;

    public DailySummaryService(DrinkLogRepository drinkLogRepository, UserGoalService userGoalService) {
        this.drinkLogRepository = drinkLogRepository;
        this.userGoalService = userGoalService;
    }

    public DailySummaryResponse getSummary(Long userId, String date) {
        LocalDate targetDate = parseDate(date);

        LocalDateTime start = targetDate.atStartOfDay();
        LocalDateTime end = targetDate.plusDays(1).atStartOfDay();

        List<DrinkLog> logs = drinkLogRepository
                .findByUser_IdAndDrankAtBetweenOrderByDrankAtAsc(userId, start, end);

        int totalMl = logs.stream()
                .mapToInt(DrinkLog::getAmountMl)
                .sum();

        UserGoalResponse goal = userGoalService.getGoal(userId);
        int goalMl = goal.getGoalMl();

        double achievementRate = goalMl > 0
                ? Math.round((totalMl * 100.0 / goalMl) * 10) / 10.0
                : 0.0;

        int remainingMl = Math.max(0, goalMl - totalMl);

        return new DailySummaryResponse(
                userId,
                targetDate.toString(),
                totalMl,
                goalMl,
                achievementRate,
                remainingMl
        );
    }

    private LocalDate parseDate(String date) {
        if (date == null || date.isBlank()) {
            return LocalDate.now();
        }
        return LocalDate.parse(date);
    }
}