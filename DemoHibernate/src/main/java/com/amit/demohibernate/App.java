package com.amit.demohibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	Alien amit = new Alien();
    	amit.setAid(102);
    	amit.setAname("Aman");
    	amit.setColor("Red");
    	
    	Configuration con=new Configuration();
    	con.configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);
    	SessionFactory sf=con.buildSessionFactory();
    	Session session=sf.openSession();
    	
    	Transaction tx=session.beginTransaction();
    	session.save(amit);
    	tx.commit();
    }
}
