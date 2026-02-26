package com.vlad.revolut_expenses_tracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthTestController {
    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}
