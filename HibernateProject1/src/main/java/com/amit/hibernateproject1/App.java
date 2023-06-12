package com.amit.hibernateproject1;

import java.util.ArrayList;
import java.util.List;

import com.amit.hibernateproject1.entity.BankAccount;
import com.amit.hibernateproject1.entity.Customer;
import com.amit.hibernateproject1.entity.OrderData;
import com.amit.hibernateproject1.entity.Person;
import com.amit.hibernateproject1.repository.CustomerRepository;
import com.amit.hibernateproject1.repository.OrderDataRepository;
import com.amit.hibernateproject1.repository.PersonRepository;

public class App {
	public static void main(String[] args) {
//		Person person = new Person(14, "Sarthak kumar", "Male", 23, "9993598705");
//		
//		PersonRepository repository = new PersonRepository();
//		repository.savePerson(person);
//		
//		OrderData data = new OrderData("ThinkPad", 7, "Laptop");
//		OrderDataRepository dataRepository = new OrderDataRepository();
//		dataRepository.saveOrderData(data);
//		
//		person.setOrderData(data);
//		
//		data.setPerson(person);
//		System.out.println(repository.getPersonById(14));

		 CustomerRepository repository = new CustomerRepository();
		 BankAccount account1 = new BankAccount("Canara","37158320");
		 BankAccount account2 = new BankAccount("SBI","37158321");
		 BankAccount account3 = new BankAccount("Kotak","37158322");
		 BankAccount account4= new BankAccount("AXIS","37158323");
		 BankAccount account5 = new BankAccount("HDFC","37158324");
		 List<BankAccount> list= new ArrayList<>();
		 list.add(account1);
		 list.add(account2);
		 list.add(account3);
		 list.add(account4);
		 list.add(account5);
		 
		 Customer customer = new Customer("Amit","Bokaro",list);
		 repository.saveCustomer(customer);
//		 
//		 Customer customer2= repository.getCustomerById(1);
//		 
//		 List<BankAccount> accounts=customer2.getAccount();
//		 
//		 accounts.forEach(System.out::println);
//		 

		
		
		 
	
	}
}

// delete and update