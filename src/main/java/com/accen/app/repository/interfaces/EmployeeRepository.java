package com.accen.app.repository.interfaces;

import java.util.List;

import javax.inject.Named;

import com.accen.app.datamodel.Employee;

@Named
public interface EmployeeRepository {
	/**
	 *insert employee into DB
	 */
	public Employee insert(Employee emp);
	
	/**
	 * 
	 * @return top 10 salaried employee
	 */
	public List<Employee> getTop();
	
	/**
	 * delete the employee
	 */
	public void delete(long id);
	
	public List<Employee> getHierarchy(Employee emp);
	
	/**
	 * get employee details from empId
	 */
	public Employee getEmployeeById(long id);
	
	/**
	 * rows updated before deleting the employee
	 */
	public int updateManager(long id, long managerId);
	

}
