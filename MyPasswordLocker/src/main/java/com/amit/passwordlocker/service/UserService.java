package com.amit.passwordlocker.service;

import com.amit.passwordlocker.entity.UserDetails;

public interface UserService {
	
	String saveUser(UserDetails user);
	
	String updateUser(UserDetails user);

	UserDetails userLogin(String email, String password);
	
	String deleteUser(int id);

}
