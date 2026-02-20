package com.yeoul.waterapp.dto;

import java.util.List;

public class CupPresetsResponse {
    private Long userId;
    private List<Integer> presets;

    public CupPresetsResponse() {
    }

    public CupPresetsResponse(Long userId, List<Integer> presets) {
        this.userId = userId;
        this.presets = presets;
    }

    // Getters
    public Long getUserId() {
        return userId;
    }

    public List<Integer> getPresets() {
        return presets;
    }

    // Setters
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setPresets(List<Integer> presets) {
        this.presets = presets;
    }
}