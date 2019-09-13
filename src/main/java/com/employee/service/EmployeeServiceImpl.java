package com.employee.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeDao;
import com.employee.entity.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDao employeeDao;
	
	
    @Autowired
	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}
    
    
	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}


	@Override
	@Transactional
	public void save(Employee theEmployee) {
		employeeDao.save(theEmployee);
	}


	@Override
	@Transactional
	public void deleteById(int id) {
		employeeDao.deleteById(id);		
	}


	@Override
	@Transactional
	public Employee findById(int id) {
		return employeeDao.findById(id);
	}
	
}
