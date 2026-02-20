package com.yeoul.waterapp.dto;

public class PushSettingsResponse {
    private Long userId;
    private String fcmToken;
    private Boolean enabled;
    private Integer intervalMinutes;
    private String sleepStart;
    private String sleepEnd;

    public PushSettingsResponse() {
    }

    public PushSettingsResponse(Long userId, String fcmToken, Boolean enabled,
                                Integer intervalMinutes, String sleepStart, String sleepEnd) {
        this.userId = userId;
        this.fcmToken = fcmToken;
        this.enabled = enabled;
        this.intervalMinutes = intervalMinutes;
        this.sleepStart = sleepStart;
        this.sleepEnd = sleepEnd;
    }

    // Getters
    public Long getUserId() {
        return userId;
    }

    public String getFcmToken() {
        return fcmToken;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public Integer getIntervalMinutes() {
        return intervalMinutes;
    }

    public String getSleepStart() {
        return sleepStart;
    }

    public String getSleepEnd() {
        return sleepEnd;
    }

    // Setters
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void setIntervalMinutes(Integer intervalMinutes) {
        this.intervalMinutes = intervalMinutes;
    }

    public void setSleepStart(String sleepStart) {
        this.sleepStart = sleepStart;
    }

    public void setSleepEnd(String sleepEnd) {
        this.sleepEnd = sleepEnd;
    }
}