package com.amit.hibernateproject1.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.amit.hibernateproject1.entity.BankAccount;
import com.amit.hibernateproject1.entity.Customer;
import com.amit.hibernateproject1.util.EntityManagerFactoryUtil;

public class CustomerRepository {
	private EntityManager manager=
			EntityManagerFactoryUtil.getFactory().createEntityManager();
	
	public void saveCustomer(Customer customer)
	{
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.persist(customer);
		transaction.commit();
	} 
	
	public Customer getCustomerById(int id)
	{
		return  manager.find(Customer.class, id);
	}
	 public Customer updateCustomer(Customer customer, List<BankAccount> list) {
	        EntityTransaction transaction = manager.getTransaction();
	        transaction.begin();
	        for(BankAccount l:list)
	        {
	        	manager.remove(l);
	        }
	        manager.merge(customer);
	        transaction.commit();
	        return null;
	    }

	    public void deleteCustomer(Customer customer) {
	        EntityTransaction transaction = manager.getTransaction();
	        transaction.begin();
	        manager.remove(customer);
	        transaction.commit();
	        
	    }
	
}
