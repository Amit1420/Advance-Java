package com.amit.hibernateproject1.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.amit.hibernateproject1.entity.OrderData;


public class OrderDataRepository {
	
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("abhi").createEntityManager();
	}
	
	public String saveOrderData(OrderData orderData) {
		EntityManager manager = getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(orderData);
		transaction.commit();
		return "Data Saved";
	}
	
	public String UpdateOrderData(OrderData orderData) {
		EntityManager manager = getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.merge(orderData);
		transaction.commit();
		return "Data updated";
	}
	
	public OrderData getOrderById(int id) {
		EntityManager manager = getEntityManager();
		return manager.find(OrderData.class, id);
	}
	
	public String deleteOrderData(int id) {
		EntityManager manager = getEntityManager();
		OrderData orderData = manager.find(OrderData.class, id);
		if(orderData != null) {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.remove(orderData);
			transaction.commit();
			return "Data Deleted";
		}
		else {
			return "No data Found";
		}
	}
	
	public List getAllData() {
		EntityManager manager = getEntityManager();
		Query query = manager.createQuery("from OrderData o");
		List list = query.getResultList();
		return list;
	}

}
