package com.budgetplanner.backend.transaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record Transaction(
        UUID id,
        TransactionType type,
        BigDecimal amount,
        LocalDate date,
        String description,
        String category) {
}