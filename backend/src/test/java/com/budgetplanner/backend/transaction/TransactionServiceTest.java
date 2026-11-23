package com.budgetplanner.backend.transaction;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TransactionServiceTest {

    private final TransactionService service = new TransactionService();

    @Test
    void balanceIsIncomeMinusExpenses() {
        service.add("u1", TransactionType.INCOME, new BigDecimal("100.00"), null, "Salary", null);
        service.add("u1", TransactionType.EXPENSE, new BigDecimal("30.50"), null, "Lunch", "Food");

        assertEquals(new BigDecimal("69.50"), service.balance("u1"));
    }

    @Test
    void balanceOfNewUserIsZero() {
        assertEquals(BigDecimal.ZERO, service.balance("unknown"));
    }

    @Test
    void rejectsZeroOrNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () ->
                service.add("u1", TransactionType.INCOME, BigDecimal.ZERO, null, "x", null));
        assertThrows(IllegalArgumentException.class, () ->
                service.add("u1", TransactionType.INCOME, new BigDecimal("-5"), null, "x", null));
    }

    @Test
    void expenseNeedsCategory() {
        assertThrows(IllegalArgumentException.class, () ->
                service.add("u1", TransactionType.EXPENSE, BigDecimal.TEN, null, "x", " "));
    }

    @Test
    void listIsNewestFirst() {
        service.add("u1", TransactionType.INCOME, BigDecimal.ONE, LocalDate.of(2026, 11, 1), "old", null);
        service.add("u1", TransactionType.INCOME, BigDecimal.ONE, LocalDate.of(2026, 11, 20), "new", null);

        assertEquals("new", service.list("u1").getFirst().description());
    }

    @Test
    void usersDoNotSeeEachOthersData() {
        service.add("u1", TransactionType.INCOME, BigDecimal.TEN, null, "mine", null);

        assertTrue(service.list("u2").isEmpty());
    }
}