package com.yeoul.waterapp.service;

import com.yeoul.waterapp.domain.PushSettings;
import com.yeoul.waterapp.domain.User;
import com.yeoul.waterapp.dto.PushSettingsRequest;
import com.yeoul.waterapp.dto.PushSettingsResponse;
import com.yeoul.waterapp.dto.PushTokenRequest;
import com.yeoul.waterapp.repository.PushSettingsRepository;
import com.yeoul.waterapp.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;

@Service
public class PushSettingsService {

    private final UserRepository userRepository;
    private final PushSettingsRepository pushSettingsRepository;

    public PushSettingsService(UserRepository userRepository, PushSettingsRepository pushSettingsRepository) {
        this.userRepository = userRepository;
        this.pushSettingsRepository = pushSettingsRepository;
    }

    @Transactional
    public PushSettingsResponse savePushToken(Long userId, PushTokenRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        PushSettings settings = pushSettingsRepository.findByUser_Id(userId)
                .orElseGet(() -> new PushSettings(user, null, true, 60));

        settings.setFcmToken(request.getFcmToken());
        pushSettingsRepository.save(settings);

        return toResponse(settings);
    }

    @Transactional
    public PushSettingsResponse updateSettings(Long userId, PushSettingsRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        PushSettings settings = pushSettingsRepository.findByUser_Id(userId)
                .orElseGet(() -> new PushSettings(user, null, true, 60));

        if (request.getEnabled() != null) {
            settings.setEnabled(request.getEnabled());
        }
        if (request.getIntervalMinutes() != null) {
            settings.setIntervalMinutes(request.getIntervalMinutes());
        }
        if (request.getSleepStart() != null) {
            settings.setSleepStart(LocalTime.parse(request.getSleepStart()));
        }
        if (request.getSleepEnd() != null) {
            settings.setSleepEnd(LocalTime.parse(request.getSleepEnd()));
        }

        pushSettingsRepository.save(settings);

        return toResponse(settings);
    }

    public PushSettingsResponse getSettings(Long userId) {
        PushSettings settings = pushSettingsRepository.findByUser_Id(userId)
                .orElseThrow(() -> new RuntimeException("Push settings not found"));

        return toResponse(settings);
    }

    private PushSettingsResponse toResponse(PushSettings settings) {
        return new PushSettingsResponse(
                settings.getUser().getId(),
                settings.getFcmToken(),
                settings.getEnabled(),
                settings.getIntervalMinutes(),
                settings.getSleepStart() != null ? settings.getSleepStart().toString() : null,
                settings.getSleepEnd() != null ? settings.getSleepEnd().toString() : null
        );
    }
}