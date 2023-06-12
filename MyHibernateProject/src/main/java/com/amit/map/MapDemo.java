package com.amit.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
//        // creating question
//        Question q1 = new Question();
//        q1.setQuestionId(1212);
//        q1.setQuestion("What is java ?");
//        
//        // creating answer
//        Answer ans1 = new Answer();
//        ans1.setAnswerId(343);
//        ans1.setAnswer("Java is programming langauage");
//        ans1.setQuestion(q1);
//        
//        Answer ans2 = new Answer();
//        ans2.setAnswerId(348);
//        ans2.setAnswer("With the help of java we can create softwares");
//        ans2.setQuestion(q1);
//        
//        Answer ans3 = new Answer();
//        ans3.setAnswerId(363);
//        ans3.setAnswer("Java has different type of frameworks");
//        ans3.setQuestion(q1);
//       
//        
//        
//        List<Answer> list=new ArrayList<Answer>();
//        list.add(ans1);
//        list.add(ans2);
//        list.add(ans3);
//        q1.setAnswer(list);
        
        
       
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
//        
//        // save
//        s.save(q1);
//        s.save(ans1);
//        s.save(ans2);
//        s.save(ans3);
        
         Question q = (Question)s.get(Question.class, 1212);
         System.out.println(q.getQuestion());
         for(Answer a: q.getAnswer())
         {
        	 System.out.println(a.getAnswer());
         }
        tx.commit();
        
        //fetching
       
        s.close();
        factory.close();

	}

}
