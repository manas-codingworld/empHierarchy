package com.accen.app.services.interfaces;

import java.util.List;

import javax.inject.Named;

import com.accen.app.datamodel.Employee;

/**
 * 
 * @author manasranjan
 * business services interface for the employee service
 *
 */
@Named
public interface EmployeeService {


	/**
	 *insert employee into DB
	 */
	public Employee insert(Employee emp);

	public List<Employee> getHierarchy(Employee emp);

	/**
	 * 
	 * @return top 10 salaried employee
	 */
	public List<Employee> getTop();

	public void delete(long id);
}


