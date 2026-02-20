package com.yeoul.waterapp.dto;

import java.util.List;

public class MonthlyStatsResponse {
    private Long userId;
    private int year;
    private int month;
    private int totalMl;
    private int avgDailyMl;
    private int goalMl;
    private double avgAchievementRate;
    private int totalDays;
    private int achievedDays;
    private List<DailyStats> dailyStats;

    public MonthlyStatsResponse() {
    }

    public MonthlyStatsResponse(Long userId, int year, int month, int totalMl, int avgDailyMl,
                                int goalMl, double avgAchievementRate, int totalDays,
                                int achievedDays, List<DailyStats> dailyStats) {
        this.userId = userId;
        this.year = year;
        this.month = month;
        this.totalMl = totalMl;
        this.avgDailyMl = avgDailyMl;
        this.goalMl = goalMl;
        this.avgAchievementRate = avgAchievementRate;
        this.totalDays = totalDays;
        this.achievedDays = achievedDays;
        this.dailyStats = dailyStats;
    }

    // Getters
    public Long getUserId() {
        return userId;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
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

    public int getTotalDays() {
        return totalDays;
    }

    public int getAchievedDays() {
        return achievedDays;
    }

    public List<DailyStats> getDailyStats() {
        return dailyStats;
    }

    // Setters
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
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

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    public void setAchievedDays(int achievedDays) {
        this.achievedDays = achievedDays;
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