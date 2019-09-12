package com.employee.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	private EntityManager entityManager;
	
	
    @Autowired
	public EmployeeDaoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}


	@Override
	public List<Employee> findAll() {
		// get the current hibernate session
				Session currentSession = entityManager.unwrap(Session.class);
				
				// create a query
				Query<Employee> theQuery =
						currentSession.createQuery("from Employee", Employee.class);
				
				// execute query and get result list
				List<Employee> employees = theQuery.getResultList();
				
				// return the results		
				return employees;
	}
	
}
