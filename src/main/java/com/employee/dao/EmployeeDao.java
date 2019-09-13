package com.employee.dao;

import java.util.List;

import com.employee.entity.Employee;

public interface EmployeeDao {
	public List<Employee> findAll();
	public void save(Employee theEmployee);
	public void deleteById(int id);
	Employee findById(int id);
}
