package com.amit.k2.controller;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.amit.k2.dto.Admin;
import com.amit.k2.dto.Visitor;
import com.amit.k2.repository.AdminDAOImp;
import com.amit.k2.repository.VisitorDAOImp;
import com.amit.k2.service.VisitorServiceImp;

public class Controller {
	public static void main(String[] args) {
		
//		Scanner sc=new Scanner(System.in);
//		System.out.println("**************************************************** \n"+
//                "************ Welcome to my Software...! ************ \n"				
//	+            "**************************************************** \n");
//		System.out.println("Select the option which  you want to use ");
//		System.out.println("1. Admin Login  \n"
//				+ "2. New Visitor Registration  \n"+"3. Vistor Login \n"+"4. Exit");			
//	    System.out.println("Enter your Choice: ");
//	    int choice=sc.nextInt();
//	    for(;;)
//	    {
//	    	switch(choice)
//	    	{
//	    		case 1 : 
//	    			Admin admin = new Admin();
//	    			admin.setId(1);
//	    			admin.setUserName("amit1420");
//	    		`	admin.setPassword("Misti@143");
//	    		    AdminDAOImp daoImp = new AdminDAOImp();
//	    			daoImp.saveAdmin(admin);
//	    			System.out.println("***************** Admin Login ***************");
//	    			System.out.println("Enter your username : ");
//	    			String username=sc.nextLine();
//	    			sc.nextLine();
//	    			System.out.println("Enter your password : ");
//	    			String password=sc.nextLine();
//	    			
//	    			daoImp.adminLogin(username, password);
//	    			
//	    	}
//	    	System.out.println("Do you want to continue? Y/y");
//			char ch = sc.next().charAt(0);
//			
//			if(ch == 'y' || ch == 'Y') 
//				continue;
//			else
//			{
//				System.out.println("Sir/Madam, Its so nice having you..!");
//				System.out.println("Thank you for  using the software");
//				System.out.println("Visit Again");
//				break;
//			}
//	    }
//

//	    Admin admin = new Admin();
//		admin.setId(1);
//		admin.setUserName("amit1420");
//		admin.setPassword("Misti@143");
//	    AdminDAOImp daoImp = new AdminDAOImp();
//		daoImp.saveAdmin(admin);
	    
	    

//		
//		daoImp.adminLogin("amit","Misti");
		
//		Visitor visitor = new Visitor();
//		visitor.setId(1);
//		visitor.setAddress("Bokaro");
//		visitor.setAge(29);
//		visitor.setEmail("ajay80999@gmail.com");
//		visitor.setGender("Male");
//		visitor.setName("Ajay");
//		visitor.setPassword("Ajay@12345");
//		visitor.setPhoneNo("9973858075");
//		visitor.setDob(Date.valueOf("1996-10-10"));
//		
//		
		VisitorDAOImp visitorDAOImp = new VisitorDAOImp();
	    
//		System.out.println(visitorDAOImp.saveVisitor(visitor));		
//		
		List<Visitor> list = visitorDAOImp.getAllRegisteredVisitor();
		if(list!=null)
			list.forEach(System.out::println);
		else System.out.println("No visitor data found in DB");	
//		
//		Visitor deleteVisitor = visitorDAOImp.deleteVisitor(1);
//		System.out.println(deleteVisitor);
//		
//	    visitorDAOImp.visitorLogin("amitkumar80999@gmail.com","Amit@123");
//	    
//	    Visitor validVisitorById = visitorDAOImp.getValidVisitorById(1);
//	    System.out.println(validVisitorById);
	    
//	    VisitorServiceImp imp = new VisitorServiceImp();
//	    List<Visitor> sortByAge = imp.sortRegisteredVisitorsByAge();
//	    System.out.println("*******************Sort By Age ***********************");
//	    if(sortByAge!=null)
//			sortByAge.forEach(System.out::println);
//		else System.out.println("No visitor data found in DB");
//	    
//	    System.out.println("*******************Sort By Email ***********************");
//	    List<Visitor> sortByEmail = imp.sortRegisteredVisitorsByEmail();
//	    if(sortByEmail!=null)
//			sortByEmail.forEach(System.out::println);
//		else System.out.println("No visitor data found in DB");
//	    
//	    System.out.println("*******************Sort By Email ***********************");
//	    List<Visitor> sortByName = imp.sortRegisteredVisitorsByName();
//	    if(sortByName!=null)
//			sortByName.forEach(System.out::println);
//		else System.out.println("No visitor data found in DB");
	    
//		Visitor deleteVisitor = visitorDAOImp.deleteVisitor(1);
//		System.out.println(deleteVisitor);
		
		
		
		
	}

}
