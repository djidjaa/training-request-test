package com.iconsoftware.training.model;

import java.time.LocalDate;

public class TrainingRequest {

    private double cost;
    private int days;
    private LocalDate createdAt;
    private Status status;

    // Enum des statuts
    public enum Status {
        PENDING,
        APPROVED,
        REJECTED_BUDGET,
        REJECTED_DAYS
    }

    // Constructeur
    public TrainingRequest(double cost, int days, LocalDate createdAt) {
        this.cost = cost;
        this.days = days;
        this.createdAt = createdAt;
        this.status = Status.PENDING;
    }

    // Getters & Setters
    public double getCost() {
        return cost;
    }

    public int getDays() {
        return days;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
