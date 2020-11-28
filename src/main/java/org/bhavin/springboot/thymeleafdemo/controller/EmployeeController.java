package org.bhavin.springboot.thymeleafdemo.controller;

import java.util.List;

import org.bhavin.springboot.thymeleafdemo.entity.Employee;
import org.bhavin.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	// Map data to view employee list
	@GetMapping("/list")
	public String viewEmployee(Model theModel) {
		
		// get employees from database
		List<Employee> theEmployees = employeeService.findAll();
		
		// add data to spring model
		theModel.addAttribute("employees", theEmployees);
		
		return "list-employees";
	}
	
}
