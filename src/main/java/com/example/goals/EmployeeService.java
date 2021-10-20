package com.example.goals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.example.goals.Employee.Gender;

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
    
    public boolean isMale(Employee emp) {
    	if(emp.getGender() == Gender.Male) {
    		return true;
    	}
    	return false;
    }
    
    public boolean isFemale(Employee emp) {
    	if(emp.getGender() == Gender.Female) {
    		return true;
    	}
    	return false;
    }
    
    
    
//    @OverLoading
    public List<Employee> getEmployees(Gender gender) {
    	try 
    	{
        List <Employee> emp = new ArrayList<>();
        List <Employee> askedEmp = new ArrayList<>();
        emp = repository.findAll();
        	for(int i=0; i<emp.size(); i++) {
        		if(emp.get(i).getGender()==gender) {
        			askedEmp.add(emp.get(i));
        		}
        	}
        	return askedEmp;
    	}
    	catch(Exception ex) {
    		return (List<Employee>) ex;
    	}
    }

    public void deleteEmployee(Integer id) {
        repository.deleteById(id);
    }
}
