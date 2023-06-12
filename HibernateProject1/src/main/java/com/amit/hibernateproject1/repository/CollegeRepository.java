package com.amit.hibernateproject1.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.amit.hibernateproject1.entity.College;
import com.amit.hibernateproject1.util.EntityManagerFactoryUtil;

public class CollegeRepository {
	private EntityManager manager=
			EntityManagerFactoryUtil.getFactory().createEntityManager();
	
	public String saveCollege(College college)
	{
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.persist(college);
		transaction.commit();
		return "Data Saved";
	} 
	public College getCollegeById(int id)
	{
		College college = manager.find(College.class, id);
		return college;
	}

}
