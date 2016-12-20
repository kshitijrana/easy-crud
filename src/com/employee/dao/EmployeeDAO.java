package com.employee.dao;

import java.util.List;

import com.employee.model.Employee;


public interface EmployeeDAO {
	public void addEmployee(Employee e);
	public void deleteEmployee(int ID);
	public void updateEmployee(Employee e);
	public List<Employee> getAllEmployees(); 
	public boolean checkIfEmployeeExists(Employee e);
	public Employee getEmployeeByID(int ID);

}
