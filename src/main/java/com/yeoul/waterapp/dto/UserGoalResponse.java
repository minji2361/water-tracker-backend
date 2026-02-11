package com.yeoul.waterapp.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserGoalResponse {
    private Long userId;
    private int age;
    private String gender;

    private Double weightKg;     // 입력 체중
    private int baseMl;          // 나이/성별 기반
    private int weightBasedMl;   // kg*n 기반
    private int goalMl;          // 최종 목표량
    private String rule;         // 어떤 규칙이 적용됐는지
}