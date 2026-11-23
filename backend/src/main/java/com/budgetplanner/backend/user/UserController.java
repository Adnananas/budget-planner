package com.budgetplanner.backend.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> createAnonymousUser() {
        return Map.of("id", UUID.randomUUID().toString());
    }
}