package com.yeoul.waterapp.controller;

import com.yeoul.waterapp.dto.DrinkCreateRequest;
import com.yeoul.waterapp.dto.DrinkResponse;
import com.yeoul.waterapp.service.DrinkLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DrinkLogController {

    private final DrinkLogService drinkLogService;

    // POST /users/{id}/drinks
    @PostMapping("/users/{id}/drinks")
    public DrinkResponse createDrink(@PathVariable("id") Long userId,
                                     @RequestBody DrinkCreateRequest request) {
        return drinkLogService.createDrink(userId, request);
    }

    // GET /users/{id}/drinks?date=YYYY-MM-DD
    @GetMapping("/users/{id}/drinks")
    public List<DrinkResponse> getDrinks(@PathVariable("id") Long userId,
                                         @RequestParam("date") String date) {
        return drinkLogService.getDrinksByDate(userId, date);
    }

    // DELETE /drinks/{drinkId}
    @DeleteMapping("/drinks/{drinkId}")
    public void deleteDrink(@PathVariable Long drinkId) {
        drinkLogService.deleteDrink(drinkId);
    }
}