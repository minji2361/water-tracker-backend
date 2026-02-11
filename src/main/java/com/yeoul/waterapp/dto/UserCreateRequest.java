package com.yeoul.waterapp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class UserCreateRequest {

    private String user_name;
    private String user_birth;
    private String user_gen;
    private Double user_wgt;
    private Double user_hgt;
}