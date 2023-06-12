package com.amit.passwordlocker.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserEntityManagerFactoryUtil {
	
	private static EntityManagerFactory factory;
	
	private UserEntityManagerFactoryUtil(){
		
	}
	
	public static EntityManagerFactory getFactory() {
		if(factory == null) {
			factory = Persistence.createEntityManagerFactory("amit");
		}
		return factory;
	}

}
