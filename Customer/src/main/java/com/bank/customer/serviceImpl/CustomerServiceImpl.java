package com.bank.customer.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.customer.entity.Customer;
import com.bank.customer.repository.CustomerRepository;
import com.bank.customer.service.CustomerService;

import io.micrometer.common.util.StringUtils;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer createCustomer(Customer customer) {
		customer.setAccountNumber(UUID.randomUUID().toString());
		customer.setUserName(customer.getFirstName() + "_" + customer.getLastName());
		customer.setRole("customer");
		Customer createdCustomer = customerRepository.save(customer);
		// perform any data hiding functions here and then send back the customer object
		return createdCustomer;
	}

	@Override
	public String deleteCustomer(String userName) {
		customerRepository.deleteById(userName);
		return "Customer deleted successfully";
	}

	@Override
	public String updateCustomer(Customer updatedCustomer) {
		Optional<Customer> customer = customerRepository.findById(updatedCustomer.getUserName());
		if(customer.isPresent()) {
			Customer existingCustomer = customer.get();
			if(!StringUtils.isEmpty(updatedCustomer.getAddress())) {
				existingCustomer.setAddress(updatedCustomer.getAddress());				
			}
			if(!StringUtils.isEmpty(updatedCustomer.getEmail())) {
				existingCustomer.setEmail(updatedCustomer.getEmail());
			}
			if(!StringUtils.isEmpty(updatedCustomer.getFirstName())) {
				existingCustomer.setFirstName(updatedCustomer.getFirstName());
			}
			if(!StringUtils.isEmpty(updatedCustomer.getLastName())) {
				existingCustomer.setLastName(updatedCustomer.getLastName());
			}
			if(!StringUtils.isEmpty(updatedCustomer.getMobile())) {
				existingCustomer.setMobile(updatedCustomer.getMobile());
			}
			if(!StringUtils.isEmpty(updatedCustomer.getPassword())) {
				existingCustomer.setPassword(updatedCustomer.getPassword());
			}
			// Role should not be changed , should it be ??
//			if(!StringUtils.isEmpty(updatedCustomer.getRole())) {
//				existingCustomer.setRole(updatedCustomer.getRole());
//			}
			
			customerRepository.save(existingCustomer);
			return "Customer details updated successfully !";
		}
		return "The given customer is not present, please create a new customer.";
	}

	@Override
	public Customer viewCustomer(String userName) {
		Optional<Customer> customer = customerRepository.findById(userName);
		// implement customer exception throwing if the customer is not present
		// check it by using isPresent() method
		// extra activity
		// set the password to null and also hide sensitive information
		return customer.get();
	}

	@Override
	public List<Customer> viewAllCustomers() {
		List<Customer> allCustomers = customerRepository.findAll();
		// set the password to null and also hide sensitive information
		// extra activity
		return allCustomers;
	}
	
	

}
