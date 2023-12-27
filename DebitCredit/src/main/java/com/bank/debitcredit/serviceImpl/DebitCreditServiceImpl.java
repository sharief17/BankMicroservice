package com.bank.debitcredit.serviceImpl;

import java.util.UUID;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.debitcredit.entity.Customer;
import com.bank.debitcredit.entity.DebitCredit;
import com.bank.debitcredit.externalService.CustomerService;
import com.bank.debitcredit.repository.DebitCreditRepository;
import com.bank.debitcredit.service.DebitCreditService;

@Service
@Slf4j
public class DebitCreditServiceImpl implements DebitCreditService {

    @Autowired
    private DebitCreditRepository debitCreditRepository;

    @Autowired
    private CustomerService customerService;

    @Override
    public String debitMoney(DebitCredit transaction) {
        transaction.setTransactionId(UUID.randomUUID().toString());
        transaction.setType("debit");

        Customer customer = customerService.getCustomerByAccountNumber(transaction.getAccountNumber());

        if (customer.getAmount() < transaction.getAmount()) {
            return "Insufficient balance in your account";
        } else {
            customer.setAmount(customer.getAmount() - transaction.getAmount());
        }

        customerService.updateAndSaveCustomer(customer);
        debitCreditRepository.save(transaction);
        return "Amount Debitted successfully , current balance is " + customer.getAmount();
    }

    @Override
    public String creditMoney(DebitCredit transaction) {
        transaction.setTransactionId(UUID.randomUUID().toString());
        transaction.setType("credit");

        Customer customer = customerService.getCustomerByAccountNumber(transaction.getAccountNumber());
        customer.setAmount(customer.getAmount() + transaction.getAmount());

        customerService.updateAndSaveCustomer(customer);
        debitCreditRepository.save(transaction);
        return "Amount Credited successfully , current balance is " + customer.getAmount();
    }

}
