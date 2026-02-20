package com.yeoul.waterapp.dto;

public class DailySummaryResponse {
    private Long userId;
    private String date;
    private int totalMl;
    private int goalMl;
    private double achievementRate;
    private int remainingMl;

    public DailySummaryResponse() {
    }

    public DailySummaryResponse(Long userId, String date, int totalMl, int goalMl,
                                double achievementRate, int remainingMl) {
        this.userId = userId;
        this.date = date;
        this.totalMl = totalMl;
        this.goalMl = goalMl;
        this.achievementRate = achievementRate;
        this.remainingMl = remainingMl;
    }

    // Getters
    public Long getUserId() {
        return userId;
    }

    public String getDate() {
        return date;
    }

    public int getTotalMl() {
        return totalMl;
    }

    public int getGoalMl() {
        return goalMl;
    }

    public double getAchievementRate() {
        return achievementRate;
    }

    public int getRemainingMl() {
        return remainingMl;
    }

    // Setters
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTotalMl(int totalMl) {
        this.totalMl = totalMl;
    }

    public void setGoalMl(int goalMl) {
        this.goalMl = goalMl;
    }

    public void setAchievementRate(double achievementRate) {
        this.achievementRate = achievementRate;
    }

    public void setRemainingMl(int remainingMl) {
        this.remainingMl = remainingMl;
    }
}