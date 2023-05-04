package com.amit.dynamiccrudoperation;

import java.util.List;

public class TestDAO {

	public static void main(String[] args) {
//		Student s = new Student(102,"Sushmita","sushmita@gmail.com","Python");
		StudentDAO dao = new StudentDAO();
		List<Student> list = dao.getAllStudent();
		if(list!=null)
		list.forEach(System.out::println);
		else System.out.println("No student data found in DB");

	}

}
