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
@RequestMapping("/goals")
public class GoalController {
    @Autowired
    GoalService goalService;

    private static final Logger log = LoggerFactory.getLogger(GoalController.class);
    @GetMapping("")
    public List<Goal> list() {
    	log.info("All goals are " + goalService.listAllGoal().toString());
        return goalService.listAllGoal();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Goal> get(@PathVariable Integer id) {
        try {
            Goal goal = goalService.getUser(id);
            log.info("Goal for given id is " + goalService.getUser(id));
            return new ResponseEntity<Goal>(goal, HttpStatus.OK);
        } catch (NoSuchElementException e) {
        	log.error("no Goal found for the given id");
            return new ResponseEntity<Goal>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public ResponseEntity<String> add(@RequestBody Goal user) {
    	log.info("Goal added is :" + user.toString());
        goalService.saveUser(user);
        return new ResponseEntity<>("Goal is added SuccessFully",HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody int creditAmount, @PathVariable Integer id) {
        try {
            Goal existGoal = goalService.getUser(id);
            log.info("Credit Amount is :" + creditAmount);
//            user.setId(id);  
            int dueAmount = existGoal.getTargetAmount()-existGoal.getCreditAmount();
            log.info("Due amount to reach the financial goal is :" + dueAmount);
            if(dueAmount > 0 && dueAmount>=creditAmount) {
            	int updatedAmount = existGoal.getCreditAmount() + creditAmount;
            	existGoal.setCreditAmount(updatedAmount);
            	log.info("credit amount for the goal is updated successfully");
            }
            else {

                return new ResponseEntity<>("Given Amount can not be acccepted",HttpStatus.OK);
            }
            
            goalService.saveUser(existGoal);
            return new ResponseEntity<>("Goal Updated SuccessFully",HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Goal Not Found for the given ID",HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
    	try {
    		Goal existGoal = goalService.getUser(id);
    		goalService.deleteUser(id);
    	}
    	catch(NoSuchElementException e){
    		return new ResponseEntity<>("Goal Not Found for the given ID",HttpStatus.NOT_FOUND);
    	}
        return new ResponseEntity<>("Goal for id : "+id + " deleted successfully",HttpStatus.OK);
    }
}
