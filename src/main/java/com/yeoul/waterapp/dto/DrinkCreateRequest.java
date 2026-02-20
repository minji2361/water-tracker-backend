package com.yeoul.waterapp.dto;

public class DrinkCreateRequest {
    private Integer amountMl;
    private String timestamp;

    public DrinkCreateRequest() {
    }

    public Integer getAmountMl() {
        return amountMl;
    }

    public void setAmountMl(Integer amountMl) {
        this.amountMl = amountMl;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}