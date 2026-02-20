package com.yeoul.waterapp.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "drink_logs")
public class DrinkLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private Integer amountMl;

    @Column(nullable = false)
    private LocalDateTime drankAt;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    protected DrinkLog() {
    }

    public DrinkLog(User user, Integer amountMl, LocalDateTime drankAt) {
        this.user = user;
        this.amountMl = amountMl;
        this.drankAt = drankAt;
    }

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters
    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Integer getAmountMl() {
        return amountMl;
    }

    public LocalDateTime getDrankAt() {
        return drankAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}