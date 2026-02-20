package com.yeoul.waterapp.controller;

import com.yeoul.waterapp.dto.MonthlyStatsResponse;
import com.yeoul.waterapp.dto.WeeklyStatsResponse;
import com.yeoul.waterapp.service.StatsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class StatsController {

    private final StatsService statsService;

    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping("/{id}/stats/weekly")
    public WeeklyStatsResponse getWeeklyStats(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String start) {
        return statsService.getWeeklyStats(id, start);
    }

    @GetMapping("/{id}/stats/monthly")
    public MonthlyStatsResponse getMonthlyStats(
            @PathVariable("id") Long id,
            @RequestParam int year,
            @RequestParam int month) {
        return statsService.getMonthlyStats(id, year, month);
    }
}