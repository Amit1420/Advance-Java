package com.amit.passwordlocker.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import javax.persistence.TypedQuery;

import com.amit.passwordlocker.entity.UserDetails;
import com.amit.passwordlocker.util.UserEntityManagerFactoryUtil;

public class UserRepositoryImpl implements UserRepository {

	EntityManager manager = UserEntityManagerFactoryUtil.getFactory().createEntityManager();
	
	@Override
	public String saveUser(UserDetails user) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(user);
		transaction.commit();
		return "Saved";
	}

	@Override
	public String updateUser(UserDetails user) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.merge(user);
		transaction.commit();
		return "Updated";
	}

	@Override
    public UserDetails userLogin(String email, String password) {
        TypedQuery<UserDetails> query = manager.createQuery("SELECT u FROM UserDetails u WHERE u.email = :email AND u.password = :password", UserDetails.class);
        query.setParameter("email", email);
        query.setParameter("password", password);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

	@Override
	public String deleteUser(int id) {
		UserDetails userDetails = manager.find(UserDetails.class, id);
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.remove(userDetails);
		transaction.commit();
		return "Deleted";
	}

}
