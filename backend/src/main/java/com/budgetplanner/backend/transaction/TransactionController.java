package com.budgetplanner.backend.transaction;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class TransactionController {

    public record CreateRequest(TransactionType type, BigDecimal amount,
                                LocalDate date, String description, String category) {
    }

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping("/transactions")
    @ResponseStatus(HttpStatus.CREATED)
    public Transaction add(@RequestHeader("X-User-Id") String userId,
                           @RequestBody CreateRequest request) {
        return service.add(userId, request.type(), request.amount(),
                request.date(), request.description(), request.category());
    }

    @GetMapping("/transactions")
    public List<Transaction> list(@RequestHeader("X-User-Id") String userId) {
        return service.list(userId);
    }

    @GetMapping("/balance")
    public Map<String, BigDecimal> balance(@RequestHeader("X-User-Id") String userId) {
        return Map.of("balance", service.balance(userId));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleBadRequest(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
    }
}