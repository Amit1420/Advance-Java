package com.amit.myhibernateproject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Student s1 = new Student();
		s1.setId(103);
		s1.setName("Amit");
		s1.setCity("Bangalore");

		Certificate certi1 = new Certificate();
		certi1.setCourse("Android");
		certi1.setDuration("2 Months");
		s1.setCerti(certi1);

		Student s2 = new Student();
		s2.setId(104);
		s2.setName("Hyderabad");

		Certificate certi2 = new Certificate();
		certi2.setCourse("Hibernate");
		certi2.setDuration("1.5 Months");
		s2.setCerti(certi2);

		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(s1);
		s.save(s2);

		tx.commit();
		s.close();
		factory.close();

	}

}
