package com.module6.bankapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.module6.bankapp.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
