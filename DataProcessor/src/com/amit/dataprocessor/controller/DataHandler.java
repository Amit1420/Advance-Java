package com.amit.dataprocessor.controller;

import com.amit.demo.StringConverter;

public class DataHandler {
	public static void main(String[] args) {
		String data="hello world";
		StringConverter con=new StringConverter();
		System.out.println(con.stringReverser(data));
		System.out.println(con.upperCaseConverter(data));
	}
	

}
