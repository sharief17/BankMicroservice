package com.bank.debitcredit.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "customer", uniqueConstraints = { @UniqueConstraint(columnNames = { "userId", "accountNumber" }) })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {

	// see if this userId parameter is required, otherwise delete it
	private int userId;

	private String firstName;

	private String lastName;

	@Id
	private String userName;

	private String accountNumber;

	private String email;

	private String mobile;

	private String address;

	private double amount;

	@CreationTimestamp
	private LocalDateTime createdAt;

	@UpdateTimestamp
	private LocalDateTime modifiedAt;

	private String password;

	private String role;

}
