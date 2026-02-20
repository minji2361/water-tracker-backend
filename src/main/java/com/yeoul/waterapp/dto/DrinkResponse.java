package com.yeoul.waterapp.dto;

public class DrinkResponse {
    private Long id;
    private Long userId;
    private Integer amountMl;
    private String drankAt;

    public DrinkResponse() {
    }

    public DrinkResponse(Long id, Long userId, Integer amountMl, String drankAt) {
        this.id = id;
        this.userId = userId;
        this.amountMl = amountMl;
        this.drankAt = drankAt;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Integer getAmountMl() {
        return amountMl;
    }

    public String getDrankAt() {
        return drankAt;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setAmountMl(Integer amountMl) {
        this.amountMl = amountMl;
    }

    public void setDrankAt(String drankAt) {
        this.drankAt = drankAt;
    }
}