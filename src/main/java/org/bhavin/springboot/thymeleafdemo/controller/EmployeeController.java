package org.bhavin.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.bhavin.springboot.thymeleafdemo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	//Load employee data manually	
	private List<Employee> theEmployees;
	
	@PostConstruct
	private void loadData() {
		
		// create employees
		Employee empl1 = new Employee(1, "Wayne", "Rooney", "rooney@gmail.com");
		Employee empl2 = new Employee(2, "Cristiano", "Ronaldo", "cr7@gmail.com");
		Employee empl3 = new Employee(3, "Lionel", "Messi", "messi@gmail.com");
		
		//create the list
		theEmployees = new ArrayList<>();
		
		//add data to list
		theEmployees.add(empl1);
		theEmployees.add(empl2);
		theEmployees.add(empl3);
	}
	
	// Map data to view employee list
	@GetMapping("/list")
	public String viewEmployee(Model theModel) {

		// add data to spring model
		theModel.addAttribute("employees", theEmployees);
		
		return "list-employees";
	}
	
}
