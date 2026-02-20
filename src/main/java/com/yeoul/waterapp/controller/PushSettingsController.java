package com.yeoul.waterapp.controller;

import com.yeoul.waterapp.dto.PushSettingsRequest;
import com.yeoul.waterapp.dto.PushSettingsResponse;
import com.yeoul.waterapp.dto.PushTokenRequest;
import com.yeoul.waterapp.service.PushSettingsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class PushSettingsController {

    private final PushSettingsService pushSettingsService;

    public PushSettingsController(PushSettingsService pushSettingsService) {
        this.pushSettingsService = pushSettingsService;
    }

    @PostMapping("/{id}/push-token")
    public PushSettingsResponse savePushToken(
            @PathVariable("id") Long id,
            @RequestBody PushTokenRequest request) {
        return pushSettingsService.savePushToken(id, request);
    }

    @PutMapping("/{id}/push-settings")
    public PushSettingsResponse updateSettings(
            @PathVariable("id") Long id,
            @RequestBody PushSettingsRequest request) {
        return pushSettingsService.updateSettings(id, request);
    }

    @GetMapping("/{id}/push-settings")
    public PushSettingsResponse getSettings(@PathVariable("id") Long id) {
        return pushSettingsService.getSettings(id);
    }
}