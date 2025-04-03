package com.kotlin.training.repository;

import com.kotlin.training.model.Account;
import com.kotlin.training.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
