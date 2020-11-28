package org.bhavin.springboot.thymeleafdemo.controller;

import java.util.List;

import org.bhavin.springboot.thymeleafdemo.entity.Employee;
import org.bhavin.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String listEmployee(Model theModel) {
		
		// get employees from database
		List<Employee> theEmployees = employeeService.findAll();
		
		// add data to spring model
		theModel.addAttribute("employees", theEmployees);
		
		return "employees/list-employees";
	}
	
	// Map data to view single employee
	@GetMapping("/view-employee")
	public String viewEmployee(@RequestParam("employeeId") int theId, Model theModel) {
		
		// get employee details
		Employee theEmployee = employeeService.findById(theId);
		
		//add data to spring model
		theModel.addAttribute("employee", theEmployee);
		
		return "employees/view-employee";
		
	}
	
	// Map link to show add employee form
	@GetMapping("/employeeForm")
	public String employeeForm(Model theModel) {
		
		// create model to bind form data
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employees/employee-form";
		
	}
	
	// Process form data to save employee
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		
		// save the employee
		employeeService.save(theEmployee);
		
		// redirect to prevent duplicate submission
		return "redirect:/employees/list";
		
	}
	
	// Map link to show update employee
	@GetMapping("update-employee")
	public String updateEmployee(@RequestParam("employeeId") int theId, Model theModel) {
		
		// get employee details
		Employee theEmployee = employeeService.findById(theId);
		
		// populate data in model
		theModel.addAttribute("employee", theEmployee);
		
		return "employees/employee-form";
	}
}













