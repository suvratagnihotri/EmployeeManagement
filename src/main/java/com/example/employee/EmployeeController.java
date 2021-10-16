package com.example.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/goals")
public class EmployeeController {
	@Autowired
	EmployeeService service;
	
	@GetMapping("")
	public List<Employee> list(){
		return service.listAllEmployee();
	}
	
	@GetMapping("/{id}")
	public Employee get(Integer id) {
		return service.getEmployee(id);
	}
	
}
