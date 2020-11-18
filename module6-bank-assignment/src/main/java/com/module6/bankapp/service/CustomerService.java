package com.module6.bankapp.service;

import java.util.List;

import com.module6.bankapp.model.Customer;

public interface CustomerService {
	
	// method to add Customer to the bank registry
	Customer createCustomer(Customer customer);
	
	// method to update Customer in the bank registry
	Customer updateCustomer(Customer customer);
	
	// method to get list of Customer in the bank registry
	List<Customer> getAllCustomers();
	
	// method to get a Customer from the bank registry based on id provided
	Customer getCustomerById(Long customerId);
	
	// method to remove a Customer from the bank registry based on id provided
	void deleteCustomer(Long customerId);

}
