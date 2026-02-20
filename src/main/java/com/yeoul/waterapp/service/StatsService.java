package com.yeoul.waterapp.service;

import com.yeoul.waterapp.domain.DrinkLog;
import com.yeoul.waterapp.dto.MonthlyStatsResponse;
import com.yeoul.waterapp.dto.UserGoalResponse;
import com.yeoul.waterapp.dto.WeeklyStatsResponse;
import com.yeoul.waterapp.repository.DrinkLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StatsService {

    private final DrinkLogRepository drinkLogRepository;
    private final UserGoalService userGoalService;

    public StatsService(DrinkLogRepository drinkLogRepository, UserGoalService userGoalService) {
        this.drinkLogRepository = drinkLogRepository;
        this.userGoalService = userGoalService;
    }

    public WeeklyStatsResponse getWeeklyStats(Long userId, String startDateStr) {
        LocalDate startDate = parseDate(startDateStr);
        LocalDate endDate = startDate.plusDays(6);

        UserGoalResponse goal = userGoalService.getGoal(userId);
        int goalMl = goal.getGoalMl();

        LocalDateTime start = startDate.atStartOfDay();
        LocalDateTime end = endDate.plusDays(1).atStartOfDay();

        List<DrinkLog> logs = drinkLogRepository
                .findByUser_IdAndDrankAtBetweenOrderByDrankAtAsc(userId, start, end);

        Map<LocalDate, Integer> dailyTotals = logs.stream()
                .collect(Collectors.groupingBy(
                        log -> log.getDrankAt().toLocalDate(),
                        Collectors.summingInt(DrinkLog::getAmountMl)
                ));

        List<WeeklyStatsResponse.DailyStats> dailyStats = new ArrayList<>();
        int totalMl = 0;
        double totalAchievement = 0.0;

        for (int i = 0; i < 7; i++) {
            LocalDate date = startDate.plusDays(i);
            int dayTotal = dailyTotals.getOrDefault(date, 0);
            double achievement = goalMl > 0
                    ? Math.round((dayTotal * 100.0 / goalMl) * 10) / 10.0
                    : 0.0;

            dailyStats.add(new WeeklyStatsResponse.DailyStats(
                    date.toString(),
                    dayTotal,
                    achievement
            ));

            totalMl += dayTotal;
            totalAchievement += achievement;
        }

        int avgDailyMl = totalMl / 7;
        double avgAchievementRate = Math.round((totalAchievement / 7) * 10) / 10.0;

        return new WeeklyStatsResponse(
                userId,
                startDate.toString(),
                endDate.toString(),
                totalMl,
                avgDailyMl,
                goalMl,
                avgAchievementRate,
                dailyStats
        );
    }

    public MonthlyStatsResponse getMonthlyStats(Long userId, int year, int month) {
        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.plusMonths(1).minusDays(1);
        int totalDays = endDate.getDayOfMonth();

        UserGoalResponse goal = userGoalService.getGoal(userId);
        int goalMl = goal.getGoalMl();

        LocalDateTime start = startDate.atStartOfDay();
        LocalDateTime end = endDate.plusDays(1).atStartOfDay();

        List<DrinkLog> logs = drinkLogRepository
                .findByUser_IdAndDrankAtBetweenOrderByDrankAtAsc(userId, start, end);

        Map<LocalDate, Integer> dailyTotals = logs.stream()
                .collect(Collectors.groupingBy(
                        log -> log.getDrankAt().toLocalDate(),
                        Collectors.summingInt(DrinkLog::getAmountMl)
                ));

        List<MonthlyStatsResponse.DailyStats> dailyStats = new ArrayList<>();
        int totalMl = 0;
        double totalAchievement = 0.0;
        int achievedDays = 0;

        for (int i = 0; i < totalDays; i++) {
            LocalDate date = startDate.plusDays(i);
            int dayTotal = dailyTotals.getOrDefault(date, 0);
            double achievement = goalMl > 0
                    ? Math.round((dayTotal * 100.0 / goalMl) * 10) / 10.0
                    : 0.0;

            if (dayTotal >= goalMl) {
                achievedDays++;
            }

            dailyStats.add(new MonthlyStatsResponse.DailyStats(
                    date.toString(),
                    dayTotal,
                    achievement
            ));

            totalMl += dayTotal;
            totalAchievement += achievement;
        }

        int avgDailyMl = totalDays > 0 ? totalMl / totalDays : 0;
        double avgAchievementRate = totalDays > 0
                ? Math.round((totalAchievement / totalDays) * 10) / 10.0
                : 0.0;

        return new MonthlyStatsResponse(
                userId,
                year,
                month,
                totalMl,
                avgDailyMl,
                goalMl,
                avgAchievementRate,
                totalDays,
                achievedDays,
                dailyStats
        );
    }

    private LocalDate parseDate(String date) {
        if (date == null || date.isBlank()) {
            return LocalDate.now();
        }
        return LocalDate.parse(date);
    }
}