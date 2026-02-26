package com.vlad.revolut_expenses_tracker.controller;

import com.vlad.revolut_expenses_tracker.model.Expense;
import com.vlad.revolut_expenses_tracker.repository.ExpenseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseRepository expenseRepository;

    public ExpenseController(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @PostMapping
    public ResponseEntity<Expense> createExpense(@RequestBody Expense expense) {
        Expense saved = expenseRepository.save(expense);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}