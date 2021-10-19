package com.example.goals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    
//    @OverLoading
    public List<Employee> getEmployees(String gender) {
        List <Employee> emp = new ArrayList<>();
        List <Employee> askedEmp = new ArrayList<>();
        emp = repository.findAll();
        if(gender.toString() == "male") {
        	for(int i=0; i<emp.size(); i++) {
        		if(emp.get(i).isMale()) {
        			askedEmp.add(emp.get(i));
        		}
        	}
        	return askedEmp;
        }
//        if(gender.toString() == "female") {
//        	for(int i=0; i<emp.size(); i++) {
//        		if(emp.get(i).isFemale()) {
//        			askedEmp.add(emp.get(i));
//        		}
//        	}
//        	return askedEmp;
//        }
        
        return null;
    }

    public void deleteEmployee(Integer id) {
        repository.deleteById(id);
    }
}
