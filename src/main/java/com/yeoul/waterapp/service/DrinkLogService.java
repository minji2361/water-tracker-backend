package com.yeoul.waterapp.service;

import com.yeoul.waterapp.domain.DrinkLog;
import com.yeoul.waterapp.domain.User;
import com.yeoul.waterapp.dto.DrinkCreateRequest;
import com.yeoul.waterapp.dto.DrinkResponse;
import com.yeoul.waterapp.repository.DrinkLogRepository;
import com.yeoul.waterapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.*;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DrinkLogService {

    private final UserRepository userRepository;
    private final DrinkLogRepository drinkLogRepository;

    public DrinkResponse createDrink(Long userId, DrinkCreateRequest request) {
        if (request.getAmountMl() == null || request.getAmountMl() <= 0) {
            throw new IllegalArgumentException("amountMl must be > 0");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        LocalDateTime drankAt = parseTimestampOrNow(request.getTimestamp());

        DrinkLog saved = drinkLogRepository.save(
                DrinkLog.builder()
                        .user(user)
                        .amountMl(request.getAmountMl())
                        .drankAt(drankAt)
                        .build()
        );

        return toResponse(saved);
    }

    public List<DrinkResponse> getDrinksByDate(Long userId, String date) {
        // date: yyyy-MM-dd
        LocalDate targetDate = parseDate(date);

        LocalDateTime start = targetDate.atStartOfDay();
        LocalDateTime end = targetDate.plusDays(1).atStartOfDay();

        return drinkLogRepository
                .findByUser_IdAndDrankAtBetweenOrderByDrankAtAsc(userId, start, end)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public void deleteDrink(Long drinkId) {
        if (!drinkLogRepository.existsById(drinkId)) {
            throw new RuntimeException("DrinkLog not found");
        }
        drinkLogRepository.deleteById(drinkId);
    }

    private DrinkResponse toResponse(DrinkLog log) {
        return DrinkResponse.builder()
                .id(log.getId())
                .userId(log.getUser().getId())
                .amountMl(log.getAmountMl())
                .drankAt(log.getDrankAt().toString())
                .build();
    }

    private LocalDate parseDate(String date) {
        if (date == null || date.isBlank()) {
            throw new IllegalArgumentException("date query param is required (yyyy-MM-dd)");
        }
        try {
            return LocalDate.parse(date);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("date must be yyyy-MM-dd");
        }
    }

    private LocalDateTime parseTimestampOrNow(String timestamp) {
        if (timestamp == null || timestamp.isBlank()) {
            return LocalDateTime.now();
        }
        try {
            // ISO-8601 LocalDateTime: 2026-02-11T09:30:00
            return LocalDateTime.parse(timestamp);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("timestamp must be ISO-8601 like 2026-02-11T09:30:00");
        }
    }
}