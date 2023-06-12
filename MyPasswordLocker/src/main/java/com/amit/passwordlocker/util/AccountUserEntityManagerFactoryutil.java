package com.amit.passwordlocker.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AccountUserEntityManagerFactoryutil {
	
	private static EntityManagerFactory factory;
	
	private AccountUserEntityManagerFactoryutil(){
		
	}
	
	public static EntityManagerFactory getFactory() {
		if(factory == null) {
			factory = Persistence.createEntityManagerFactory("amit");
		}
		return factory;
	}

}
