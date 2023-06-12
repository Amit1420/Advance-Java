package com.amit.hibernateproject1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bank_account")
public class BankAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="bank_name",nullable = false)
	private String bankName;
	@Column(name="account_numb",nullable = false,unique=true)
	private String accountNumb;
	
	
	public BankAccount() {
		super();
	}
	public BankAccount(String bankName, String accountNumb) {
		super();
		this.bankName = bankName;
		this.accountNumb = accountNumb;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccountNumb() {
		return accountNumb;
	}
	public void setAccountNumb(String accountNumb) {
		this.accountNumb = accountNumb;
	}
	@Override
	public String toString() {
		return "BankAccount [id=" + id + ", bankName=" + bankName + ", accountNumb=" + accountNumb + "]";
	}
	
	

}
