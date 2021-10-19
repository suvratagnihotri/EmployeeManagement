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
    private String gender;

    public Employee() {
    }

    public Employee(int id, String name, int salary, String gender) {
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
//other setters and getters

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
	
	public void setGender(String gender) {
		this.gender = gender.toLowerCase();
	}
	
	public String getGender() {
		return this.gender;
	}
	
	public boolean isMale() {
		if(this.gender.toString() == "male") {
			return true;
		}
		return false;
	}
	
//	public boolean isFemale() {
//		if(this.gender == "female") {
//			return true;
//		}
//		return false;
//	}
	
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append(" Name : " + this.getName() + " Salary : " + this.getSalary() + " Gender :" +this.getGender()); 
		return str.toString();
	}
}
