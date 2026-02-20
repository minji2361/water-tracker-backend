package com.yeoul.waterapp.controller;

import com.yeoul.waterapp.dto.DailySummaryResponse;
import com.yeoul.waterapp.service.DailySummaryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class DailySummaryController {

    private final DailySummaryService dailySummaryService;

    public DailySummaryController(DailySummaryService dailySummaryService) {
        this.dailySummaryService = dailySummaryService;
    }

    @GetMapping("/{id}/summary")
    public DailySummaryResponse getSummary(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String date) {
        return dailySummaryService.getSummary(id, date);
    }
}