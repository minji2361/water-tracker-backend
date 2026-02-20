package com.yeoul.waterapp.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;
    private String birthDate;
    private String gender;
    private Double weight;
    private Double height;

    @Column(name = "cup_presets")
    private String cupPresets;

    private LocalDateTime createdAt;

    protected User() {
    }

    public User(String nickname, String birthDate, String gender, Double weight, Double height) {
        this.nickname = nickname;
        this.birthDate = birthDate;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
    }

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getHeight() {
        return height;
    }

    public String getCupPresets() {
        return cupPresets;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // Setters
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public void setCupPresets(String cupPresets) {
        this.cupPresets = cupPresets;
    }
}