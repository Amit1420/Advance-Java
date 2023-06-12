package com.amit.hibernateproject1.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.amit.hibernateproject1.entity.Person;


public class PersonRepository {
	
	private EntityManager getEntityManager() {
		// EntityManagerFactory is auto closable connection, we don't need to close manually.
		return Persistence.createEntityManagerFactory("abhi").createEntityManager();
	}
	
	public String savePerson(Person person) {
		
		EntityManager manager = getEntityManager();
//		EntityManagerFactory factory = 
//		Persistence.createEntityManagerFactory("abhi"); // persistence unit name(as a string we have to provide like "abhi") 
													    // which will be declared in persistence.xml file
//		EntityManager manager = factory.createEntityManager();  
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(person);  // only save the data in database
		transaction.commit();
		return "Data Saved";
	}
	
	public String updatePerson(Person person) {
		
		EntityManager manager = getEntityManager(); 
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.merge(person);  // save and update the data in database
		transaction.commit();
		return "Data updated";
	}
	
	public String deletePerson(int id) {
		
		EntityManager manager = getEntityManager(); 
		Person person = manager.find(Person.class, id);
		EntityTransaction transaction = manager.getTransaction();
		if(person != null) {
			transaction.begin();
			manager.remove(person);  // save and update the data in database
			transaction.commit();
			return "Data updated";
		}
		else {
			return "No data found";
		}
	}
	
	public List getAllData() {
		EntityManager manager = getEntityManager();
		Query query = manager.createQuery("from Person p");
		List list = query.getResultList();
		return list;
	}
	
	public List getPhoneNumberByName(String name) {
		EntityManager manager = getEntityManager();
		Query query = 
				manager.createQuery("select p.phoneNumber "
						+ "from Person p where p.name=?1");
		query.setParameter(1, name);
		List list = query.getResultList();
		return list;
	}
	
	public List getAllDataByNameAge(String name, int age) {
		EntityManager manager = getEntityManager();
		Query query = manager.createQuery("from Person p where p.name=?1 AND p.age=?2");
		query.setParameter(1, name);
		query.setParameter(2, age);
		List list = query.getResultList();
		return list;
	}
	
	
	public Person getPersonById(int id) {
		EntityManager manager = getEntityManager();
		return manager.find(Person.class, id);
	}

}