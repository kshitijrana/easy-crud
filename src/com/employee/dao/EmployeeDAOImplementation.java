package com.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.employee.model.Employee;
import com.employee.util.DBUtil;

public class EmployeeDAOImplementation implements EmployeeDAO{
	private Connection con;
	public EmployeeDAOImplementation(){
		con = DBUtil.getConnection();
	}
	
	public void addEmployee(Employee e){
		try {
			String query = "INSERT INTO EMPLOYEE VALUES(?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,e.getEmpID());
			ps.setString(2,e.getEmpName());
			ps.setString(3,e.getEmpAddress());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e1) {
			// FIXME Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void deleteEmployee(int ID){
		try {
			String query = "DELETE FROM EMPLOYEE WHERE empID=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,ID);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e1) {
			// FIXME Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void updateEmployee(Employee e){
		try {
			String query = "UPDATE EMPLOYEE SET empName=?, empAddress=? where empID=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,e.getEmpName());
			ps.setString(2,e.getEmpAddress());
			ps.setInt(3,e.getEmpID());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e1) {
			// FIXME Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public List<Employee> getAllEmployees(){
		List<Employee> emp = new ArrayList<Employee>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE");
			while(rs.next()){
				Employee e = new Employee();
				e.setEmpID(rs.getInt("empID"));
				e.setEmpName(rs.getString("empName"));
				e.setEmpAddress(rs.getString("empAddress"));
				emp.add(e);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// FIXME Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}
	
	public Employee getEmployeeByID(int ID){
		Employee e = new Employee();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM EMPLOYEE WHERE empID=?");
			ps.setInt(1,ID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				e.setEmpID(rs.getInt("empID"));
				e.setEmpName(rs.getString("empName"));
				e.setEmpAddress(rs.getString("empAddress"));
			}
			rs.close();
			ps.close();
		} catch (SQLException e1) {
			// FIXME Auto-generated catch block
			e1.printStackTrace();
		}
		return e;		
	}
	
	public boolean checkIfEmployeeExists(Employee e){
		List<Employee> list = getAllEmployees();
		int flag = 0;
		for(Employee f : list){
			if(f.getEmpID() == e.getEmpID()){
				flag=1;
				break;
			}
		}
		if(flag == 0){
			return false;
		}
		else{
			return true;
		}
		
	}
}
