package com.bank.debitcredit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.debitcredit.entity.DebitCredit;
import com.bank.debitcredit.service.DebitCreditService;

@RestController
@RequestMapping("/debitcredit")
public class DebitCreditController {
	
	@Autowired
	private DebitCreditService debitCreditService;
	
	@PostMapping("/debit")
	public ResponseEntity<String> debitMoney(@RequestBody DebitCredit transaction){
		String response = debitCreditService.debitMoney(transaction);
		return new ResponseEntity<String>(response, HttpStatus.CREATED);
	}
	
	@PostMapping("/credit")
	public ResponseEntity<String> creditMoney(@RequestBody DebitCredit transaction){
		String response = debitCreditService.creditMoney(transaction);
		return new ResponseEntity<String>(response, HttpStatus.CREATED);
	}
	
}
