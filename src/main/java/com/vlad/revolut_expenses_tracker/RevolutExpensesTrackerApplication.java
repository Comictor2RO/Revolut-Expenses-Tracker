package com.vlad.revolut_expenses_tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.vlad.revolut_expenses_tracker.model")
@EnableJpaRepositories("com.vlad.revolut_expenses_tracker.repository")
public class RevolutExpensesTrackerApplication {
	public static void main(String[] args) {
		SpringApplication.run(RevolutExpensesTrackerApplication.class, args);
	}
}

