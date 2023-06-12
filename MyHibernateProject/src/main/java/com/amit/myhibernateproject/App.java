package com.amit.myhibernateproject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println("Project Started...");
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        // creating student
        Student st = new Student();
        st.setId(102);
        st.setName("Anmol");
        st.setCity("Jamshedpur");
        System.out.println(st);
        
        // creating object of address class
        Address ad = new Address();
        ad.setStreet("Street2");
        ad.setCity("Dhanbad");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(1234.234);
        
        // Reading image
        
        FileInputStream fis=new FileInputStream("src/main/java/1.jpg");
        byte[] data=new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
        
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        session.save(st);
        session.save(ad);
        tx.commit();
        session.close();
        System.out.println("Done.....");
    }
}
