package com.yeoul.waterapp.controller;

import com.yeoul.waterapp.dto.DrinkCreateRequest;
import com.yeoul.waterapp.dto.DrinkResponse;
import com.yeoul.waterapp.service.DrinkLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DrinkLogController {

    private final DrinkLogService drinkLogService;

    public DrinkLogController(DrinkLogService drinkLogService) {
        this.drinkLogService = drinkLogService;
    }

    @PostMapping("/users/{id}/drinks")
    public DrinkResponse createDrink(@PathVariable("id") Long userId,
                                     @RequestBody DrinkCreateRequest request) {
        return drinkLogService.createDrink(userId, request);
    }

    @GetMapping("/users/{id}/drinks")
    public List<DrinkResponse> getDrinks(@PathVariable("id") Long userId,
                                         @RequestParam("date") String date) {
        return drinkLogService.getDrinksByDate(userId, date);
    }

    @DeleteMapping("/drinks/{drinkId}")
    public void deleteDrink(@PathVariable Long drinkId) {
        drinkLogService.deleteDrink(drinkId);
    }
}