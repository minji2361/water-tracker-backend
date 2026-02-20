package com.yeoul.waterapp.dto;

public class PushTokenRequest {
    private String fcmToken;

    public PushTokenRequest() {
    }

    public String getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }
}