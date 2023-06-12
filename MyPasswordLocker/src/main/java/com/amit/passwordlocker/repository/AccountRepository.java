package com.amit.passwordlocker.repository;

import java.util.List;

import com.amit.passwordlocker.entity.Account;

public interface AccountRepository {
	
	String saveAccount(Account account);
	
	String updateAccount(Account account);
	
	Account accountLogin(String email, String password);
	
	String deleteAccount(int id);
	
	List<Account> getAllAccount();
	
	List<Account> getAccountByAccountName(String name);

}
