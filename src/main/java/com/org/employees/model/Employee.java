package com.org.employees.model;

public class Employee {
	
	int employeeID;
	
	String employeeName;
	
	String employeeEmail;
	
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	@Override
	public String toString() {
		return "EmployeeDetails [employeeID=" + employeeID + ", employeeName=" + employeeName + ", employeeEmail="
				+ employeeEmail + "]";
	}
	
	
	
}
