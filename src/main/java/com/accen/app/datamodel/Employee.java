package com.accen.app.datamodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author manasranjan
 * data model class
 *
 */
@Table
@Entity
public class Employee {

	private String name;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private Double salary;

	private int rating;
	
	private String role;
	
	private Long mgrId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getMgrId() {
		return mgrId;
	}

	public void setMgrId(Long mgrId) {
		this.mgrId = mgrId;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
} 

