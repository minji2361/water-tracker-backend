package com.yeoul.waterapp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yeoul.waterapp.domain.User;
import com.yeoul.waterapp.dto.CupPresetsRequest;
import com.yeoul.waterapp.dto.CupPresetsResponse;
import com.yeoul.waterapp.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CupPresetService {

    private final UserRepository userRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public CupPresetService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public CupPresetsResponse updatePresets(Long userId, CupPresetsRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        try {
            String presetsJson = objectMapper.writeValueAsString(request.getPresets());
            user.setCupPresets(presetsJson);
            userRepository.save(user);

            return new CupPresetsResponse(userId, request.getPresets());

        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to update cup presets", e);
        }
    }

    public CupPresetsResponse getPresets(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Integer> presets = new ArrayList<>();

        try {
            String cupPresets = user.getCupPresets();
            if (cupPresets != null && !cupPresets.isBlank()) {
                presets = objectMapper.readValue(cupPresets, new TypeReference<List<Integer>>() {});
            } else {
                presets = List.of(100, 200, 300, 500);
            }
        } catch (JsonProcessingException e) {
            presets = List.of(100, 200, 300, 500);
        }

        return new CupPresetsResponse(userId, presets);
    }
}