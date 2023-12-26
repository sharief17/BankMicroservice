package com.bank.debitcredit.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DebitCredit {
	
	@Id
	private String transactionId;
	
	private String accountNumber;
	
	private double amount;
	
	private String type;
	
	@CreationTimestamp
	private LocalDateTime transactedAt;

}
