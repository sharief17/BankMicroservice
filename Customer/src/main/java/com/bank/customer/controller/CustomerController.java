package com.bank.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.customer.entity.Customer;
import com.bank.customer.service.CustomerService;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostConstruct
	public void initDatabase() {
		customerService.initAdminandCustomer();
	}

	@PostMapping("/create")
	public ResponseEntity<Customer> createNewCustomer(@RequestBody Customer customer) {
		Customer newCustomer = customerService.createCustomer(customer);
		return new ResponseEntity<Customer>(newCustomer, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{userName}")
	public ResponseEntity<String> deleteCustomer(@PathVariable String userName) {
		return new ResponseEntity<String>(customerService.deleteCustomer(userName), HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateExistingCustomer(@RequestBody Customer updatedCustomer){
		return new ResponseEntity<String>(customerService.updateCustomer(updatedCustomer), HttpStatus.OK);
	}
	
	@GetMapping("/view/{userName}")
	public ResponseEntity<Customer> viewSpecificCustomer(@PathVariable String userName){
		return new ResponseEntity<Customer>( customerService.viewCustomer(userName), HttpStatus.OK);
	}
	
	@GetMapping("/viewAll")
	public ResponseEntity<List<Customer>> viewAllCustomers(){
		return new ResponseEntity<List<Customer>>( customerService.viewAllCustomers(), HttpStatus.OK);
	}

}
