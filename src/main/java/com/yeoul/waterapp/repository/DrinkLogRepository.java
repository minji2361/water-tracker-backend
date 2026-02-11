package com.yeoul.waterapp.repository;

import com.yeoul.waterapp.domain.DrinkLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface DrinkLogRepository extends JpaRepository<DrinkLog, Long> {

    List<DrinkLog> findByUser_IdAndDrankAtBetweenOrderByDrankAtAsc(
            Long userId,
            LocalDateTime startInclusive,
            LocalDateTime endExclusive
    );
}