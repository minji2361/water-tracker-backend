package com.yeoul.waterapp.controller;

import com.yeoul.waterapp.dto.UserGoalResponse;
import com.yeoul.waterapp.service.UserGoalService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserGoalController {

    private final UserGoalService userGoalService;

    public UserGoalController(UserGoalService userGoalService) {
        this.userGoalService = userGoalService;
    }

    @GetMapping("/{id}/goal")
    public UserGoalResponse getUserGoal(@PathVariable("id") Long id) {
        return userGoalService.getGoal(id);
    }
}