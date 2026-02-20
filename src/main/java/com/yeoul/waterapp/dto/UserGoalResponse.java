package com.yeoul.waterapp.dto;

public class UserGoalResponse {
    private Long userId;
    private int age;
    private String gender;
    private Double weightKg;
    private int baseMl;
    private int weightBasedMl;
    private int goalMl;
    private String rule;

    public UserGoalResponse() {
    }

    public UserGoalResponse(Long userId, int age, String gender, Double weightKg,
                            int baseMl, int weightBasedMl, int goalMl, String rule) {
        this.userId = userId;
        this.age = age;
        this.gender = gender;
        this.weightKg = weightKg;
        this.baseMl = baseMl;
        this.weightBasedMl = weightBasedMl;
        this.goalMl = goalMl;
        this.rule = rule;
    }

    // Getters
    public Long getUserId() {
        return userId;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public Double getWeightKg() {
        return weightKg;
    }

    public int getBaseMl() {
        return baseMl;
    }

    public int getWeightBasedMl() {
        return weightBasedMl;
    }

    public int getGoalMl() {
        return goalMl;
    }

    public String getRule() {
        return rule;
    }

    // Setters
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setWeightKg(Double weightKg) {
        this.weightKg = weightKg;
    }

    public void setBaseMl(int baseMl) {
        this.baseMl = baseMl;
    }

    public void setWeightBasedMl(int weightBasedMl) {
        this.weightBasedMl = weightBasedMl;
    }

    public void setGoalMl(int goalMl) {
        this.goalMl = goalMl;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }
}