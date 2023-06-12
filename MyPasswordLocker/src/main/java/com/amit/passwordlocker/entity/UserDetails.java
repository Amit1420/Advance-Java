package com.amit.passwordlocker.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user_details")
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String name;
	
	private String gender;
	
	@Column(nullable = false)
	private Date dob;
	
	@Column(name = "phone_number", nullable = false, unique = true)
	private String phoneNumber;
	
	@Column(nullable =  false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String password;

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", name=" + name + ", gender=" + gender + ", dob=" + dob + ", phoneNumber="
				+ phoneNumber + ", email=" + email + ", password=" + password + "]";
	}

}
