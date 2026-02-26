package com.vlad.revolut_expenses_tracker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vlad.revolut_expenses_tracker.model.Expense;
import com.vlad.revolut_expenses_tracker.repository.ExpenseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(controllers = ExpenseController.class,
        excludeAutoConfiguration = {
                org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
        })

class ExpenseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExpenseRepository expenseRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateExpense() throws Exception {
        Expense expense = new Expense();
        expense.setId(1L);
        expense.setTitle("Coffee");
        expense.setAmount(new BigDecimal("12.50"));

        when(expenseRepository.save(any(Expense.class))).thenReturn(expense);

        mockMvc.perform(post("/api/expenses")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(expense)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.title").value("Coffee"))
                .andExpect(jsonPath("$.amount").value(12.50));
    }
}