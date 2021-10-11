package com.example.goals;

import com.example.goals.Goal;
import com.example.goals.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class GoalService {
    @Autowired
    private GoalRepository goalRepository;
    public List<Goal> listAllGoal() {
        return goalRepository.findAll();
    }

    public void saveUser(Goal goal) {
        goalRepository.save(goal);
    }

    public Goal getUser(Integer id) {
        return goalRepository.findById(id).get();
    }

    public void deleteUser(Integer id) {
        goalRepository.deleteById(id);
    }
}
