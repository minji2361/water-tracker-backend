package com.yeoul.waterapp.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DrinkResponse {
    private Long id;
    private Long userId;
    private Integer amountMl;
    private String drankAt; // ISO 문자열로 내려줌
}