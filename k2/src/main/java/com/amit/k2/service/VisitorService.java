package com.amit.k2.service;

import java.util.List;

import com.amit.k2.dto.Visitor;

public interface VisitorService {
	public String saveVisitor(Visitor visitor);
	public String updateVisitor(Visitor visitor);
	public Visitor getVisitorById(int id);
	public Visitor deleteVisitor(int id); 
	public Visitor visitorLogin(String email,String password);
	
	public List<Visitor> getAllRegisteredVisitor();
	public List<Visitor> getAllValidVisitor();
	public Visitor getValidVisitorById(int id);
	
	public List<Visitor> sortRegisteredVisitorsByName();
	public List<Visitor> sortRegisteredVisitorsByEmail();
	public List<Visitor> sortRegisteredVisitorsByAge();
	public List<Visitor> sortValidVisitorsByName();
	public List<Visitor> sortValidVisitorsByEmail();
	public List<Visitor> sortValidVisitorsByAge();

}
