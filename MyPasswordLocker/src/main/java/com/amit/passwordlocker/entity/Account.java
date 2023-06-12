package com.amit.passwordlocker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "a_id")
	private Integer id;
	
	@Column(name = "account_name", nullable = false)
	private String accountName;
	
	@Column(name = "user_name", nullable = false)
	private String userName;
	
	@Column(nullable = false)
	private String password;
	
	private String review;

	@Column(name = "user_id", nullable = false)
	private Integer userId;
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", accountName=" + accountName + ", userName=" + userName + ", password="
				+ password + ", review=" + review + "]";
	}
	
}
