package com.example.employee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	private int employeeID;
	private String employeeName;
	private int salary;
	private String gender;
	
	public Employee(int employeeID, String employeeName, int salary, String gender) {
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.salary = salary;
		this.gender = gender;
	}
	
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getEmployeeID() {
		return this.employeeID;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeName() {
		return this.employeeName;
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
	
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("Employee ID "+getEmployeeID() +" EmployeeName " + getEmployeeName() + " EmployeeSalary "+ getSalary() + " EmployeeGender " + getGender());
		return str.toString();
	}
}
