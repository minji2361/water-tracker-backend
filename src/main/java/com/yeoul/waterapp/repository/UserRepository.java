package com.yeoul.waterapp.repository;

import com.yeoul.waterapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}