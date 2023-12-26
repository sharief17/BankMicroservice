package com.bank.debitcredit.service;

import org.springframework.stereotype.Service;

import com.bank.debitcredit.entity.DebitCredit;

public interface DebitCreditService {
	
	String debitMoney(DebitCredit transaction);
	
	String creditMoney(DebitCredit transaction);

}
