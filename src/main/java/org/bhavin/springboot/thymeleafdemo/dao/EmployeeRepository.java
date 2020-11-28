package org.bhavin.springboot.thymeleafdemo.dao;

import java.util.List;

import org.bhavin.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// add a method to sort by last name
	public List<Employee> findAllByOrderByLastNameAsc();
	
}
