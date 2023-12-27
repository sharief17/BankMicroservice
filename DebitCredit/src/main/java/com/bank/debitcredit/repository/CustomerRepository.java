package com.bank.debitcredit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.debitcredit.entity.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    Customer findByAccountNumber(String accountNumber);

}
