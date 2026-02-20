package com.yeoul.waterapp.dto;

import java.util.List;

public class WeeklyStatsResponse {
    private Long userId;
    private String startDate;
    private String endDate;
    private int totalMl;
    private int avgDailyMl;
    private int goalMl;
    private double avgAchievementRate;
    private List<DailyStats> dailyStats;

    public WeeklyStatsResponse() {
    }

    public WeeklyStatsResponse(Long userId, String startDate, String endDate, int totalMl,
                               int avgDailyMl, int goalMl, double avgAchievementRate,
                               List<DailyStats> dailyStats) {
        this.userId = userId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalMl = totalMl;
        this.avgDailyMl = avgDailyMl;
        this.goalMl = goalMl;
        this.avgAchievementRate = avgAchievementRate;
        this.dailyStats = dailyStats;
    }

    // Getters
    public Long getUserId() {
        return userId;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public int getTotalMl() {
        return totalMl;
    }

    public int getAvgDailyMl() {
        return avgDailyMl;
    }

    public int getGoalMl() {
        return goalMl;
    }

    public double getAvgAchievementRate() {
        return avgAchievementRate;
    }

    public List<DailyStats> getDailyStats() {
        return dailyStats;
    }

    // Setters
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setTotalMl(int totalMl) {
        this.totalMl = totalMl;
    }

    public void setAvgDailyMl(int avgDailyMl) {
        this.avgDailyMl = avgDailyMl;
    }

    public void setGoalMl(int goalMl) {
        this.goalMl = goalMl;
    }

    public void setAvgAchievementRate(double avgAchievementRate) {
        this.avgAchievementRate = avgAchievementRate;
    }

    public void setDailyStats(List<DailyStats> dailyStats) {
        this.dailyStats = dailyStats;
    }

    // Inner class
    public static class DailyStats {
        private String date;
        private int totalMl;
        private double achievementRate;

        public DailyStats() {
        }

        public DailyStats(String date, int totalMl, double achievementRate) {
            this.date = date;
            this.totalMl = totalMl;
            this.achievementRate = achievementRate;
        }

        // Getters
        public String getDate() {
            return date;
        }

        public int getTotalMl() {
            return totalMl;
        }

        public double getAchievementRate() {
            return achievementRate;
        }

        // Setters
        public void setDate(String date) {
            this.date = date;
        }

        public void setTotalMl(int totalMl) {
            this.totalMl = totalMl;
        }

        public void setAchievementRate(double achievementRate) {
            this.achievementRate = achievementRate;
        }
    }
}