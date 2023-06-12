package com.amit.passwordlocker.service;

import com.amit.passwordlocker.entity.UserDetails;
import com.amit.passwordlocker.repository.UserRepository;
import com.amit.passwordlocker.repository.UserRepositoryImpl;
import com.amit.passwordlocker.util.ValidUser;

public class UserServiceImp implements UserService {

	private UserRepository repository;
	
	{
		repository = new UserRepositoryImpl();
	}
	
	@Override
	public String saveUser(UserDetails user) {
		return repository.saveUser(user);
	}

	@Override
	public String updateUser(UserDetails user) {
		return repository.updateUser(user);
	}

	@Override
	public UserDetails userLogin(String email, String password) {
		UserDetails user = repository.userLogin(email, password);
		 if(user != null) {
			 new ValidUser().setUser(user);
		 }
		 return null;
	}

	@Override
	public String deleteUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
