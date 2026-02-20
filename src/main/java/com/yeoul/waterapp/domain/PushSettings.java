package com.yeoul.waterapp.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "push_settings")
public class PushSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    private String fcmToken;
    private Boolean enabled;
    private Integer intervalMinutes;
    private LocalTime sleepStart;
    private LocalTime sleepEnd;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    protected PushSettings() {
    }

    public PushSettings(User user, String fcmToken, Boolean enabled, Integer intervalMinutes) {
        this.user = user;
        this.fcmToken = fcmToken;
        this.enabled = enabled;
        this.intervalMinutes = intervalMinutes;
    }

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // Getters
    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
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

    public LocalTime getSleepStart() {
        return sleepStart;
    }

    public LocalTime getSleepEnd() {
        return sleepEnd;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    // Setters
    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void setIntervalMinutes(Integer intervalMinutes) {
        this.intervalMinutes = intervalMinutes;
    }

    public void setSleepStart(LocalTime sleepStart) {
        this.sleepStart = sleepStart;
    }

    public void setSleepEnd(LocalTime sleepEnd) {
        this.sleepEnd = sleepEnd;
    }
}