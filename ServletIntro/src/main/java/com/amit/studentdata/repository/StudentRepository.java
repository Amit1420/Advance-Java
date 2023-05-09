package com.amit.studentdata.repository;

import java.util.ArrayList;
import java.util.List;

import com.amit.studentdata.dto.Student;

public class StudentRepository {
	public String saveStudent(Student student)
	{
		return student.toString()+" data saved successfully";
	}
	
	public List<Student> getAllData()
	{
		return new ArrayList<>();
	}

}
