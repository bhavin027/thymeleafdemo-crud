package org.bhavin.springboot.thymeleafdemo.service;

import java.util.List;

import org.bhavin.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	public Employee findById(int theId);
	public void save(Employee theEmployee);
	public void deleteById(int theId);
	
}
