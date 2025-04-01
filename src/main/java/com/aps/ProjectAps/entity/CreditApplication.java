package com.aps.ProjectAps.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "credit_Application")
public class CreditApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "income")
    private Double income;

    @NotNull
    @Column(name = "credit_score")
    private String creditScore;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotNull String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public @NotNull Double getIncome() {
        return income;
    }

    public void setIncome(@NotNull Double income) {
        this.income = income;
    }

    public @NotNull String getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(@NotNull String creditScore) {
        this.creditScore = creditScore;
    }
// Getters and Setters
}
