package com.amit.passwordlocker.repository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.amit.passwordlocker.entity.Account;
import com.amit.passwordlocker.entity.UserDetails;
import com.amit.passwordlocker.util.AccountUserEntityManagerFactoryutil;
import com.amit.passwordlocker.util.ValidUser;

public class AccountRepositoryImpl implements AccountRepository {

		private UserDetails user;

    EntityManager manager = AccountUserEntityManagerFactoryutil.getFactory().createEntityManager();

    {
        user = new ValidUser().getUser();
    }

    @Override
    public String saveAccount(Account account) {
        account.setUserId(user.getId());

        try {
            EntityTransaction transaction = manager.getTransaction();
            transaction.begin();
            manager.persist(account);
            transaction.commit();
            return "Saved";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Something went wrong";
    }

    @Override
    public String updateAccount(Account account) {
        account.setUserId(user.getId());
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.merge(account);
        transaction.commit();
        return "Updated";
    }

    @Override
    public String deleteAccount(int id) {
        Account account = manager.find(Account.class, id);
        if (account != null) {
            EntityTransaction transaction = manager.getTransaction();
            transaction.begin();
            manager.remove(account);
            transaction.commit();
        }
        return "Deleted";
    }
    /*
     * The warning "The expression of type List needs unchecked conversion to
     * conform to List<Account>" occurs because the getResultList() method 
     * returns a raw List type, and you are trying to assign it to a 
     * generic List<Account>. To resolve this warning, you can use a type cast
     * to explicitly convert the raw List to a List<Account>.
     */
    @Override
    public List<Account> getAllAccount() {
        Query query = manager.createQuery("from Account");
        List<?> resultList = query.getResultList();
        List<Account> accountList = new ArrayList<>();
        
        for (Object obj : resultList) {
            if (obj instanceof Account) {
                accountList.add((Account) obj);
            }
        }
        
        return accountList;
    }

    @Override
    public List<Account> getAccountByAccountName(String name) {
        Query query = manager.createQuery("from Account a where a.name = :name and a.userId = :userId");
        query.setParameter("name", name);
        query.setParameter("userId", user.getId());
        List<?> resultList = query.getResultList();
        List<Account> accountList = new ArrayList<>();
        
        for (Object obj : resultList) {
            if (obj instanceof Account) {
                accountList.add((Account) obj);
            }
        }
        
        return accountList;
    }

    @Override
    public Account accountLogin(String email, String password) {
        @SuppressWarnings("unchecked")
        List<Account> list = manager.createQuery("from Account a where a.email = :email and a.password = :password")
                .setParameter("email", email)
                .setParameter("password", password)
                .getResultList();

        if (!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }
  
    /*
     * The getResultStream() method is used instead of getResultList(). 
     * The stream is then mapped to the Account type using a lambda expression (obj -> (Account) obj). 
     * Finally, the results are collected into a List<Account>. 
     * This approach avoids the unchecked conversion warning by performing 
     * the type cast explicitly within the stream pipeline.
     */
//    @Override
//    public Account accountLogin(String email, String password) {
//        Query query = manager.createQuery("from Account a where a.email = :email and a.password = :password");
//        query.setParameter("email", email);
//        query.setParameter("password", password);
//        List<Account> list = query.getResultStream()
//                .map(obj -> (Account) obj)
//                .collect(Collectors.toList());
//
//        if (!list.isEmpty()) {
//            return list.get(0);
//        }
//        return null;
//    }


}
