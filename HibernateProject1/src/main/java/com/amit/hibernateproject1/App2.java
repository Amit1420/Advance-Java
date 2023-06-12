package com.amit.hibernateproject1;

import java.util.ArrayList;
import java.util.List;

import com.amit.hibernateproject1.entity.College;
import com.amit.hibernateproject1.entity.Department;
import com.amit.hibernateproject1.repository.CollegeRepository;

public class App2 {

	public static void main(String[] args) {
		College college = new College("RVSCET","831012");
		Department dept1 = new Department("ME","Sanjay",college);
		Department dept2 = new Department("CE","Murli",college);
		Department dept3 = new Department("ECE","Sushant",college);
		Department dept4 = new Department("CSE","Deobrat",college);
		Department dept5= new Department("EEE","Abhi",college);
		List<Department> list=new ArrayList<>();
		list.add(dept1);
		list.add(dept2);
		list.add(dept3);
		list.add(dept4);
		list.add(dept5);
		
		college.setDepts(list);
		CollegeRepository repository = new CollegeRepository();
//		repository.saveCollege(college);
		
	 College college2 = repository.getCollegeById(1);
	 List<Department> depts = college2.getDepts();
	 for(Department d:depts)
	 {
		 System.out.println(d.getCollege());
	 }
		

	}

}
