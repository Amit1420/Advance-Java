package com.amit.map1;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Emp {
	
	@Id
	private int eid;
	private String ename;
	
	@ManyToMany
	@JoinTable(name="emp_learn",
			joinColumns = {@JoinColumn(name="eid")},
	inverseJoinColumns = {@JoinColumn(name="pid")}
	)
	private List<Project> project;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp(int eid, String ename, List<Project> project) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.project = project;
	}
	
	
	
	
	

}
