package com.example.goals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;
    public List<Employee> listAllEmployee() {
        return repository.findAll();
    }

    public void saveEmployee(Employee employee) {
        repository.save(employee);
    }

    public Employee getEmployee(Integer id) {
        return repository.findById(id).get();
    }

    public void deleteEmployee(Integer id) {
        repository.deleteById(id);
    }
}
