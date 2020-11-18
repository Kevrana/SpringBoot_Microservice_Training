package com.module6.bankapp.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.module6.bankapp.exception.ResourceNotFoundException;
import com.module6.bankapp.model.Customer;
import com.module6.bankapp.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	
	@Override
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	
	
	@Override
	public Customer updateCustomer(Customer customer) {
		Optional<Customer> customerDb = this.customerRepository.findById(customer.getId());
		
		if(customerDb.isPresent()) {
			Customer customerUpdate = customerDb.get();
			customerUpdate.setId(customer.getId());
			customerUpdate.setName(customer.getName());
			customerUpdate.setAge(customer.getAge());
			customerUpdate.setAddress(customer.getAddress());
			customerUpdate.setAccountType(customer.getAccountType());
			customerRepository.save(customerUpdate);
			
			return customerUpdate;
		}
		else {
			throw new ResourceNotFoundException("Record not found with id: " + customer.getId());
		}
	}

	
	@Override
	public List<Customer> getAllCustomers() {
		return this.customerRepository.findAll();
	}

	
	@Override
	public Customer getCustomerById(Long customerId) {
		
		Optional<Customer> customerDb = this.customerRepository.findById(customerId);
		
		if(customerDb.isPresent()) {
			return customerDb.get();
		}
		else {
			throw new ResourceNotFoundException("Record not found with id: " + customerId);
		}

	}

	
	
	@Override
	public void deleteCustomer(Long customerId) {

		Optional<Customer> customerDb = this.customerRepository.findById(customerId);
		
		if(customerDb.isPresent()) {
			this.customerRepository.delete(customerDb.get());
		}
		else {
			throw new ResourceNotFoundException("Record not found with id: " + customerId);
		}
	}

}
