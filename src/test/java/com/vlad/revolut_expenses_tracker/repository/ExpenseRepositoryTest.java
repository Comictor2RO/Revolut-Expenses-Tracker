package com.vlad.revolut_expenses_tracker.repository;

import com.vlad.revolut_expenses_tracker.model.Expense;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class ExpenseRepositoryTest {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Test
    void shouldSaveExpense() {
        Expense expense = new Expense();
        expense.setTitle("Coffee");
        expense.setAmount(new BigDecimal("12.50"));

        Expense saved = expenseRepository.save(expense);

        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getTitle()).isEqualTo("Coffee");
        assertThat(saved.getAmount()).isEqualByComparingTo("12.50");
    }

    @Test
    void shouldFindAllExpenses() {
        Expense e1 = new Expense();
        e1.setTitle("Coffee");
        e1.setAmount(new BigDecimal("12.50"));

        Expense e2 = new Expense();
        e2.setTitle("Lunch");
        e2.setAmount(new BigDecimal("35.00"));

        expenseRepository.save(e1);
        expenseRepository.save(e2);

        List<Expense> expenses = expenseRepository.findAll();

        assertThat(expenses).hasSize(2);
    }

    @Test
    void shouldFindExpenseById() {
        Expense expense = new Expense();
        expense.setTitle("Taxi");
        expense.setAmount(new BigDecimal("50.00"));

        Expense saved = expenseRepository.save(expense);

        Optional<Expense> found = expenseRepository.findById(saved.getId());

        assertThat(found).isPresent();
        assertThat(found.get().getTitle()).isEqualTo("Taxi");
    }
}

