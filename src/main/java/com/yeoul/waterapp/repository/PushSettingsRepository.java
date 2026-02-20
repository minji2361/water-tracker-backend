package com.yeoul.waterapp.repository;

import com.yeoul.waterapp.domain.PushSettings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PushSettingsRepository extends JpaRepository<PushSettings, Long> {
    Optional<PushSettings> findByUser_Id(Long userId);
}