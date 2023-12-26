package com.bank.transfer.service;

import org.springframework.stereotype.Service;

import com.bank.transfer.entity.TransferMoney;

public interface TransferMoneyService {
	
	String transferMoney(TransferMoney transfer);

}
