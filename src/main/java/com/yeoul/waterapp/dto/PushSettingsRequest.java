package com.yeoul.waterapp.dto;

public class PushSettingsRequest {
    private Boolean enabled;
    private Integer intervalMinutes;
    private String sleepStart;
    private String sleepEnd;

    public PushSettingsRequest() {
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Integer getIntervalMinutes() {
        return intervalMinutes;
    }

    public void setIntervalMinutes(Integer intervalMinutes) {
        this.intervalMinutes = intervalMinutes;
    }

    public String getSleepStart() {
        return sleepStart;
    }

    public void setSleepStart(String sleepStart) {
        this.sleepStart = sleepStart;
    }

    public String getSleepEnd() {
        return sleepEnd;
    }

    public void setSleepEnd(String sleepEnd) {
        this.sleepEnd = sleepEnd;
    }
}