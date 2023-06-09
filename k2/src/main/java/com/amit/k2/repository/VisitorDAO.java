package com.amit.k2.repository;

import java.util.List;

import com.amit.k2.dto.Visitor;

public interface VisitorDAO {
	public String saveVisitor(Visitor visitor);
	public String updateVisitor(Visitor visitor);
	public Visitor getVisitorById(int id);
	public Visitor deleteVisitor(int id); 
	public Visitor visitorLogin(String email,String password);
	
	public List<Visitor> getAllRegisteredVisitor();
	public List<Visitor> getAllValidVisitor();
	public Visitor getValidVisitorById(int id);
	
	
	
}
