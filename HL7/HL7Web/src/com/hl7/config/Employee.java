package com.hl7.config;

public class Employee {
	
	public String name;
	public String empId;
	public String role;
public Employee(){
	System.out.println("Employee.Employee()");
}
/**
 * @return the name
 */
public String getName() {
	return name;
}
/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}
/**
 * @return the empId
 */
public String getEmpId() {
	return empId;
}
/**
 * @param empId the empId to set
 */
public void setEmpId(String empId) {
	this.empId = empId;
}
/**
 * @return the role
 */
public String getRole() {
	return role;
}
/**
 * @param role the role to set
 */
public void setRole(String role) {
	this.role = role;
}
}
