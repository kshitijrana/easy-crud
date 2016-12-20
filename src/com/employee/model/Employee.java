package com.employee.model;

public class Employee {
	private int empID;
	private String empName;
	private String empAddress;
	
	public int getEmpID(){
		return empID;
	}
	
	public String getEmpName(){
		return empName;
	}
	public String getEmpAddress(){
		return empAddress;
	}
	public void setEmpID(int empID){
		this.empID = empID;
	}
	public void setEmpName(String empName){
		this.empName = empName;
	}
	public void setEmpAddress(String empAddress){
		this.empAddress = empAddress;
	}
	
	public String toString(){
		return "Employee [empID=" + empID + " ,empName=" + empName + " ,empAddress=" + empAddress +"]";
	}
	

}
