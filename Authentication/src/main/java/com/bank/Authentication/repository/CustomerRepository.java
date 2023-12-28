package com.bank.Authentication.repository;

import com.bank.Authentication.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    Customer findByAccountNumber(String accountNumber);

}
