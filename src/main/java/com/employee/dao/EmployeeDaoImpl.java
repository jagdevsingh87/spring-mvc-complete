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
	
	
	@Override
	public void save(Employee theEmployee) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save employee
		currentSession.saveOrUpdate(theEmployee);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void deleteById(int theId) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// delete object with primary key
		Query<Employee> theQuery = 
				currentSession.createQuery(
						"delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();
	}

	@Override
	public Employee findById(int theId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the employee
		Employee theEmployee =
				currentSession.get(Employee.class, theId);
		
		// return the employee
		return theEmployee;
	}

}
