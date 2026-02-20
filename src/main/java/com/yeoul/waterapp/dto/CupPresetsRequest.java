package com.yeoul.waterapp.dto;

import java.util.List;

public class CupPresetsRequest {
    private List<Integer> presets;

    public CupPresetsRequest() {
    }

    public List<Integer> getPresets() {
        return presets;
    }

    public void setPresets(List<Integer> presets) {
        this.presets = presets;
    }
}