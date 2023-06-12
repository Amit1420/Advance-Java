package com.amit.hibernateproject1.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.amit.hibernateproject1.entity.Course;
import com.amit.hibernateproject1.util.EntityManagerFactoryUtil;

public class CourseRepository {
	
	EntityManager manager = EntityManagerFactoryUtil.getFactory().createEntityManager();
	
	public void saveCourse(Course course) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(course);
		transaction.commit();
	}
	
	public void saveAllCourse(List<Course> courses) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		for(Course c : courses) manager.persist(c);
		transaction.commit();
	}
	
	public Course getCourseById(int id) {
		return manager.find(Course.class, id);
	}
	
	public void deleteCourse(int id) {
		Course course = manager.find(Course.class, id);
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.remove(course);
		transaction.commit();
	}

}