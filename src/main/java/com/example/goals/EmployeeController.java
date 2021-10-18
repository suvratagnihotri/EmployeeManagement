package com.example.goals;

import java.util.List;
import java.util.NoSuchElementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService service;

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
    @GetMapping("")
    public List<Employee> list() {
    	log.info("All employees are " + service.listAllEmployee().toString());
        return service.listAllEmployee();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> get(@PathVariable Integer id) {
        try {
            Employee employee = service.getEmployee(id);
            log.info("employee for given id is " + service.getEmployee(id));
            return new ResponseEntity<Employee>(employee, HttpStatus.OK);
        } catch (NoSuchElementException e) {
        	log.error("no employee found for the given id");
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public ResponseEntity<String> add(@RequestBody Employee employee) {
    	log.info("employee added is :" + employee.toString());
        service.saveEmployee(employee);
        return new ResponseEntity<>("Employee is added SuccessFully",HttpStatus.OK);
    }
    
//    @PutMapping("/{id}")
//    public ResponseEntity<?> update(@RequestBody int creditAmount, @PathVariable Integer id) {
//        try {
//        	Employee existEmployee = service.getEmployee(id);
//            log.info("Credit Amount is :" + creditAmount);
////            user.setId(id);  
//            int dueAmount = existEmployee.getTargetAmount()-existGoal.getCreditAmount();
//            log.info("Due amount to reach the financial goal is :" + dueAmount);
//            if(dueAmount > 0 && dueAmount>=creditAmount) {
//            	int updatedAmount = existGoal.getCreditAmount() + creditAmount;
//            	existGoal.setCreditAmount(updatedAmount);
//            	log.info("credit amount for the goal is updated successfully");
//            }
//            else {
//
//                return new ResponseEntity<>("Given Amount can not be acccepted",HttpStatus.OK);
//            }
//            
//            goalService.saveUser(existGoal);
//            return new ResponseEntity<>("Goal Updated SuccessFully",HttpStatus.OK);
//        } catch (NoSuchElementException e) {
//            return new ResponseEntity<>("Goal Not Found for the given ID",HttpStatus.NOT_FOUND);
//        }
//    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
    	try {
    		Employee existEmployee = service.getEmployee(id);
    		service.deleteEmployee(id);
    	}
    	catch(NoSuchElementException e){
    		return new ResponseEntity<>("employee Not Found for the given ID",HttpStatus.NOT_FOUND);
    	}
        return new ResponseEntity<>("employee for id : "+id + " deleted successfully",HttpStatus.OK);
    }
}
