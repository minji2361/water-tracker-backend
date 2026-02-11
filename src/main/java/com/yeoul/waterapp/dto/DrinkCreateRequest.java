package com.yeoul.waterapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DrinkCreateRequest {
    private Integer amountMl;     // 예: 200
    private String timestamp;     // ISO-8601 예: "2026-02-11T09:30:00"
}