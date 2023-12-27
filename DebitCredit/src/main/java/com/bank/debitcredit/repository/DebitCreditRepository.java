package com.bank.debitcredit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.debitcredit.entity.DebitCredit;

@Repository
public interface DebitCreditRepository extends JpaRepository<DebitCredit, String> {

}
