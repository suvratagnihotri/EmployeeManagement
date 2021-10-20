package com.example.goals;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
    private int id;
    private String name;
    private int salary;
    private Gender gender;
    
    
    

    public Employee() {
    }

    public Employee(int id, String name, int salary, Gender gender) {
        this.id = id;
        this.name = name;
        this.gender= gender;
        this.salary = salary;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

	public void setId(Integer id2) {
		this.id = id2;
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public int getSalary() {
		return this.salary;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public Gender getGender() {
		return this.gender;
	}
	
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append(" Name : " + this.getName() + " Salary : " + this.getSalary() ); 
		return str.toString();
	}
}
