package com.example.goals;

//import com.example.goals.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<Goal, Integer>{
}
