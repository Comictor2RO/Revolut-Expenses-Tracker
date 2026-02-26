package com.vlad.revolut_expenses_tracker.repository;

import com.vlad.revolut_expenses_tracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
