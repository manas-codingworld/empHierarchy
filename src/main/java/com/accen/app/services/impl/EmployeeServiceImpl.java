package com.accen.app.services.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.accen.app.datamodel.Employee;
import com.accen.app.repository.interfaces.EmployeeRepository;
import com.accen.app.services.interfaces.EmployeeService;

/**
 * 
 * @author manasranjan
 * business services for the employee service
 *
 */
@Named
public class EmployeeServiceImpl implements EmployeeService{

	Logger logger =LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Inject
	EmployeeRepository employeeRepository;

	/**
	 *insert employee into DB
	 */
	@Override
	public Employee insert(Employee emp) {
		return employeeRepository.insert(emp);
	}

	@Override
	public List<Employee> getHierarchy(Employee emp) {
		return employeeRepository.getHierarchy(emp);
	}

	/**
	 * 
	 * @return top 10 salaried employee
	 */
	@Override
	public List<Employee> getTop() {
		return employeeRepository.getTop();
	}
	
	@Override
	public void delete(long id) {
		/**
		 * get employee details from empId
		 */
		Employee emp=employeeRepository.getEmployeeById(id);
		/**
		 * rows updated before deleting the employee
		 */
		int rowsupdated=employeeRepository.updateManager(id,emp.getMgrId());
		logger.info("rows updated {}"+rowsupdated);
		/**
		 * delete the employee
		 */
		employeeRepository.delete(id);
	}
}

