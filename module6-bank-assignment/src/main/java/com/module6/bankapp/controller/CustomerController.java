package com.module6.bankapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.module6.bankapp.model.Customer;
import com.module6.bankapp.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	// Service URL to get a list of all of the Customers
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		return ResponseEntity.ok().body(customerService.getAllCustomers());
	}

	// Service URL to get a Customer based on an id
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable long id){
		return ResponseEntity.ok().body(customerService.getCustomerById(id));
	}

	// Service URL to add a Customer
	@PostMapping("/customers")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
		return ResponseEntity.ok().body(this.customerService.createCustomer(customer));
	}

	// Service URL to update a Customer based on an id
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable long id, @RequestBody Customer customer){

		customer.setId(id);
		return ResponseEntity.ok().body(this.customerService.updateCustomer(customer));
	}

	// Service URL to delete a Customer based on an id
	@DeleteMapping("/customers/{id}")
	public HttpStatus deleteCustomer(@PathVariable long id){

		this.customerService.deleteCustomer(id);
		return HttpStatus.OK;
	}
	
}
