package com.employee.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static Connection con;
	public static Connection getConnection(){
		if(con!=null){
			return con;
		}
		
		else{
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testschema","root","root");
			} catch (ClassNotFoundException e) {
				// FIXME Auto-generated catch block
				e.printStackTrace();
			}catch (SQLException e){
				e.printStackTrace();
			}
			return con;
			
		}
	}
	
	public static void closeConnection(Connection toBeClosed){
		if(toBeClosed!=null){
			try {
				toBeClosed.close();
			} catch (SQLException e) {
				// FIXME Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			return;
		}
		
	}

}
