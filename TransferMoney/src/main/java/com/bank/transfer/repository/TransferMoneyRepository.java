package com.bank.transfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.transfer.entity.TransferMoney;

@Repository
public interface TransferMoneyRepository extends JpaRepository<TransferMoney, Integer> {

}
