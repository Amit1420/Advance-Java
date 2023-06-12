package com.amit.map1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Emp e1 = new Emp();
		Emp e2 = new Emp();

		e1.setEid(23);
		e1.setEname("Amit");

		e2.setEid(24);
		e2.setEname("sumit");

		Project p1 = new Project();
		Project p2 = new Project();
		
		p1.setPid(12);
		p1.setPname("Library Management System");
		
		p2.setPid(13);
		p1.setPname("ChatBot");
		
		List<Emp> list1=new ArrayList<Emp>();
		List<Project> list2=new ArrayList<Project>();
		list1.add(e1);
		list1.add(e2);
		
		list2.add(p1);
		list2.add(p2);
		
		e1.setProject(list2);
		p2.setEmp(list1);

		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
        
		s.save(e1);
		s.save(e2);
		s.save(p1);
		s.save(p2);
		
		
		tx.commit();

		factory.close();
	}

}
