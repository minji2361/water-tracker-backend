package com.yeoul.waterapp.controller;

import com.yeoul.waterapp.dto.UserGoalResponse;
import com.yeoul.waterapp.service.UserGoalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserGoalController {

    private final UserGoalService userGoalService;

    @GetMapping("/{id}/goal")
    public UserGoalResponse getUserGoal(@PathVariable("id") Long id) {
        return userGoalService.getGoal(id);
    }
}