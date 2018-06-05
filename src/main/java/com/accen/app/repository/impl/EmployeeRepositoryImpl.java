package com.accen.app.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accen.app.datamodel.Employee;
import com.accen.app.repository.interfaces.EmployeeRepository;

/**
 * 
 * @author manasranjan
 * DAO class for the employee service
 *
 */
@Repository
@Transactional
public class EmployeeRepositoryImpl implements EmployeeRepository{

	@PersistenceContext
	EntityManager entityManager;

	/**
	 *insert employee into DB
	 */
	@Override
	public Employee insert(Employee emp) {
		entityManager.persist(emp);
		return emp;
	}

	@Override
	public List<Employee> getHierarchy(Employee emp) {
		return null;
	}

	/**
	 * 
	 * @return top 10 salaried employee
	 */
	@Override
	public List<Employee> getTop() {
		return this.entityManager.createQuery("from Employee order by salary",Employee.class)
				.setMaxResults(10)
				.getResultList();
	}
	
	/**
	 * delete the employee
	 */
	@Override
	public void delete(long id) {
		Employee emp=getEmployeeById(id);
		if(emp!=null) {
			this.entityManager.remove(emp);
		}		
	}
	
	/**
	 * get employee details from empId
	 */
	@Override
	public Employee getEmployeeById(long id) {
		return entityManager.find(Employee.class, id);
	}
	
	/**
	 * rows updated before deleting the employee
	 */
	@Override
	public int updateManager(long id, long managerId) {
		return this.entityManager.createQuery("UPDATE Employee set mgrId = :newId WHERE mgrId=:oldId")
		.setParameter("newId", managerId)
		.setParameter("oldId", id)
		.executeUpdate();

	}
}

