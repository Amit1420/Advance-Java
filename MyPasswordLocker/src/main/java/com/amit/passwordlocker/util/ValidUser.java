package com.amit.passwordlocker.util;

import com.amit.passwordlocker.entity.UserDetails;

public class ValidUser {
	
	private static UserDetails user;

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

}
