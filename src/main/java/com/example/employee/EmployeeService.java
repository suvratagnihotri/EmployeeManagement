package com.example.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;
	
	public List<Employee> listAllEmployee(){
		return repository.findAll();
	}
	public void saveEmployee(Employee employee) {
		repository.save(employee);
	}
	public Employee getEmployee(Integer id) {
		return repository.getById(id);
	}
	public void deleteEmployee(Integer id) {
		repository.deleteById(id);
	}
}
