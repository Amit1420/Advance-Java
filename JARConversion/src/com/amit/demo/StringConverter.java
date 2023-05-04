package com.amit.demo;

public class StringConverter {
	public String upperCaseConverter(String value) {
		return value.toUpperCase();
	}

	public String lowerCaseConverter(String value) {
		return value.toLowerCase();
	}

	public String stringReverser(String value) {
		String temp = "";
		for (int i = value.length() - 1; i >= 0; i--) {
			temp += value.charAt(i);
		}
		return temp;
	}
}
