package com.amit.k2.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.amit.k2.dto.Visitor;
import com.amit.k2.repository.VisitorDAO;
import com.amit.k2.repository.VisitorDAOImp;
import com.amit.k2.util.AES;
import com.amit.k2.util.AppConstants;

public class VisitorServiceImp implements VisitorService {

	private VisitorDAO dao;
	{
		dao = new VisitorDAOImp();
	}

	@Override
	public String saveVisitor(Visitor visitor) {
		String encEmail = AES.encrypt(visitor.getEmail(), AppConstants.SECRET_KEY);
		String encPhone = AES.encrypt(visitor.getPhoneNo(), AppConstants.SECRET_KEY);
		String encAddress = AES.encrypt(visitor.getAddress(), AppConstants.SECRET_KEY);
		String encPassword = AES.encrypt(visitor.getPassword(), AppConstants.SECRET_KEY);
		visitor.setEmail(encEmail);
		visitor.setPhoneNo(encPhone);
		visitor.setAddress(encAddress);
		visitor.setPassword(encPassword);
		return dao.saveVisitor(visitor);
	}

	@Override
	public String updateVisitor(Visitor visitor) {
		 Visitor existingVisitor = dao.getVisitorById(visitor.getId());
		    if (existingVisitor == null) {
		        return "Visitor not found";
		    }
		    String encEmail = AES.encrypt(visitor.getEmail(), AppConstants.SECRET_KEY);
		    String encPhone = AES.encrypt(visitor.getPhoneNo(), AppConstants.SECRET_KEY);
		    String encAddress = AES.encrypt(visitor.getAddress(), AppConstants.SECRET_KEY);
		    String encPassword = AES.encrypt(visitor.getPassword(), AppConstants.SECRET_KEY);
		    existingVisitor.setEmail(encEmail);
		    existingVisitor.setPhoneNo(encPhone);
		    existingVisitor.setAddress(encAddress);
		    existingVisitor.setPassword(encPassword);
		    dao.updateVisitor(existingVisitor);
		    return "Visitor updated successfully";
	}

	@Override
	public Visitor getVisitorById(int id) {
		Visitor visitorById = dao.getVisitorById(id);
	    visitorById.setEmail(AES.encrypt(visitorById.getEmail(), AppConstants.SECRET_KEY));
	    visitorById.setPhoneNo(AES.encrypt(visitorById.getPhoneNo(), AppConstants.SECRET_KEY));
	    visitorById.setAddress(AES.encrypt(visitorById.getAddress(), AppConstants.SECRET_KEY));
	    visitorById.setPassword(AES.encrypt(visitorById.getPassword(), AppConstants.SECRET_KEY));
		return visitorById;
	}

	@Override
	public Visitor deleteVisitor(int id) {
	
		return  dao.deleteVisitor(id);
	}

	@Override
	public Visitor visitorLogin(String email, String password) {
		 String decEmail = AES.decrypt(email, AppConstants.SECRET_KEY);
		    String decPassword = AES.decrypt(password, AppConstants.SECRET_KEY);
		    return dao.visitorLogin(decEmail, decPassword);
	}

	@Override
	public List<Visitor> getAllRegisteredVisitor() {
		 return dao.getAllRegisteredVisitor();
	}

	@Override
	public List<Visitor> getAllValidVisitor() {
	    List<Visitor> validVisitors = dao.getAllValidVisitor();
	    for (Visitor visitor : validVisitors) {
	        visitor.setEmail(AES.encrypt(visitor.getEmail(), AppConstants.SECRET_KEY));
	        visitor.setPhoneNo(AES.encrypt(visitor.getPhoneNo(), AppConstants.SECRET_KEY));
	        visitor.setAddress(AES.encrypt(visitor.getAddress(), AppConstants.SECRET_KEY));
	        visitor.setPassword(AES.encrypt(visitor.getPassword(), AppConstants.SECRET_KEY));
	    }
	    return validVisitors;
	}

	@Override
	public Visitor getValidVisitorById(int id) {
	    Visitor validVisitorById = dao.getValidVisitorById(id);
	    if (validVisitorById != null) {
	        validVisitorById.setEmail(AES.encrypt(validVisitorById.getEmail(), AppConstants.SECRET_KEY));
	        validVisitorById.setPhoneNo(AES.encrypt(validVisitorById.getPhoneNo(), AppConstants.SECRET_KEY));
	        validVisitorById.setAddress(AES.encrypt(validVisitorById.getAddress(), AppConstants.SECRET_KEY));
	        validVisitorById.setPassword(AES.encrypt(validVisitorById.getPassword(), AppConstants.SECRET_KEY));
	    }
	    return validVisitorById;
	}

	@Override
	public List<Visitor> sortRegisteredVisitorsByName() {
	    List<Visitor> registeredVisitors = dao.getAllRegisteredVisitor();
	    Collections.sort(registeredVisitors, Comparator.comparing(Visitor::getName));
	    return registeredVisitors;
	}

	@Override
	public List<Visitor> sortRegisteredVisitorsByEmail() {
	    List<Visitor> registeredVisitors = dao.getAllRegisteredVisitor();
	    Collections.sort(registeredVisitors, Comparator.comparing(Visitor::getEmail));
	    return registeredVisitors;
	}

	@Override
	public List<Visitor> sortRegisteredVisitorsByAge() {
	    List<Visitor> registeredVisitors = dao.getAllRegisteredVisitor();
	    Collections.sort(registeredVisitors, Comparator.comparingInt(Visitor::getAge));
	    return registeredVisitors;
	}

	@Override
	public List<Visitor> sortValidVisitorsByName() {
	    List<Visitor> validVisitors = dao.getAllValidVisitor();
	    Collections.sort(validVisitors, Comparator.comparing(Visitor::getName));
	    return validVisitors;
	}

	@Override
	public List<Visitor> sortValidVisitorsByEmail() {
	    List<Visitor> validVisitors = dao.getAllValidVisitor();
	    Collections.sort(validVisitors, Comparator.comparing(Visitor::getEmail));
	    return validVisitors;
	}

	@Override
	public List<Visitor> sortValidVisitorsByAge() {
	    List<Visitor> validVisitors = dao.getAllValidVisitor();
	    Collections.sort(validVisitors, Comparator.comparingInt(Visitor::getAge));
	    return validVisitors;
	}


}
