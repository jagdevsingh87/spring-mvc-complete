package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@Controller
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@GetMapping("/")
	public String renderHome() {
		return "home";
	}

	@GetMapping("/employee")
	public String listAllEmployees(Model model) {
		List<Employee> employees = employeeService.findAll();
		model.addAttribute("employees", employees);
		return "employees-detail";
	}
	
	@PostMapping("/employee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.save(employee);
		return "redirect:/employee";
	}
	
	@GetMapping("/employee/register")
	public String registerEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employee-register";
	}

	@GetMapping("/employee/delete")
	public String deleteById(@RequestParam("employeeId") int id) {
		employeeService.deleteById(id);
		return "redirect:/employee";
	}
	
	@GetMapping("/employee/update")
	public String updateById(@RequestParam("employeeId") int id,Model model) {
		Employee employee = employeeService.findById(id);
		model.addAttribute("employee", employee);
		return "employee-register";
	}
}
