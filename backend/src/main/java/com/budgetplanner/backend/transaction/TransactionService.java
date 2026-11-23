package com.budgetplanner.backend.transaction;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class TransactionService {

    private final Map<String, List<Transaction>> store = new ConcurrentHashMap<>();

    public Transaction add(String userId, TransactionType type, BigDecimal amount,
                           LocalDate date, String description, String category) {
        if (type == null) {
            throw new IllegalArgumentException("Type is required");
        }
        if (amount == null || amount.signum() <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        if (type == TransactionType.EXPENSE && (category == null || category.isBlank())) {
            throw new IllegalArgumentException("An expense needs a category");
        }
        LocalDate effectiveDate = date != null ? date : LocalDate.now();
        Transaction transaction = new Transaction(
                UUID.randomUUID(), type, amount, effectiveDate, description, category);
        store.computeIfAbsent(userId, _ -> new CopyOnWriteArrayList<>()).add(transaction);
        return transaction;
    }

    public List<Transaction> list(String userId) {
        return store.getOrDefault(userId, List.of()).stream()
                .sorted(Comparator.comparing(Transaction::date).reversed())
                .toList();
    }

    public BigDecimal balance(String userId) {
        return store.getOrDefault(userId, List.of()).stream()
                .map(t -> t.type() == TransactionType.INCOME ? t.amount() : t.amount().negate())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}