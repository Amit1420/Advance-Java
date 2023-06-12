package com.amit.passwordlocker.repository;

import com.amit.passwordlocker.entity.UserDetails;

public interface UserRepository {
	
	String saveUser(UserDetails user);
	
	String updateUser(UserDetails user);

	UserDetails userLogin(String email, String password);
	
	String deleteUser(int id);
	
}
