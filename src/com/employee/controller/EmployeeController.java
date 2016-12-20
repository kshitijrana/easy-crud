package com.employee.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.dao.EmployeeDAO;
import com.employee.dao.EmployeeDAOImplementation;
import com.employee.model.Employee;
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet{
	public static int glo = 0;
	private EmployeeDAO dao;
	private static final long serialVersionUID = 1L;
	public EmployeeController(){
		dao = new EmployeeDAOImplementation(); 
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String forward = "";
        String action = request.getParameter( "action" ); 
        if( action.equalsIgnoreCase( "delete" ) ) {
	            forward = "/listEmployee.jsp";
	            int ID = Integer.parseInt( request.getParameter("empID") );
	            dao.deleteEmployee(ID);
	            request.setAttribute("employees", dao.getAllEmployees() );
	        }
	    else if( action.equalsIgnoreCase( "edit" ) ) {
	    		glo = 1;
	            forward = "/employee.jsp";
	            int ID = Integer.parseInt( request.getParameter("empID") );
	            Employee e = dao.getEmployeeByID(ID);
	            request.setAttribute("employee", e);
	        }
	    else if( action.equalsIgnoreCase( "insert" ) ) {
	    		glo=0;
	            forward = "/employee.jsp";
	            
	        }
	    else {
	            forward = "/listEmployee.jsp";
	            request.setAttribute("employees", dao.getAllEmployees() );
	        }
	        RequestDispatcher view = request.getRequestDispatcher( forward );
	        view.forward(request, response);
	    }	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Employee e = new Employee();
		e.setEmpID(Integer.parseInt(request.getParameter("empID")));
		e.setEmpName(request.getParameter("empName"));
		e.setEmpAddress(request.getParameter("empAddress"));
		String empID = request.getParameter("empID");
		//check if employee exists
		boolean check = dao.checkIfEmployeeExists(e);
		if(check && glo == 0){
			RequestDispatcher view = request.getRequestDispatcher("/error.jsp");
			view.forward(request,response);			
		}
		else{
			if(empID != null && glo == 0){
				dao.addEmployee(e);
				RequestDispatcher view = request.getRequestDispatcher("/listEmployee.jsp");
				request.setAttribute("employees", dao.getAllEmployees());
		        view.forward(request, response);
		    }
		

			else if(glo == 1){
				dao.updateEmployee(e);
				RequestDispatcher view = request.getRequestDispatcher("/listEmployee.jsp");
				request.setAttribute("employees", dao.getAllEmployees());
		        view.forward(request, response);
		    }
			
		}
		/*for(Employee f: dao.getAllEmployees()){
			System.out.println("ID: " + f.getEmpID());
			System.out.println("Name: " + f.getEmpName());
			System.out.println("Address: " + f.getEmpAddress());	
		}*/

		/*dao.addEmployee(e);
		String empID = request.getParameter("empID");
		if(empID == null || empID.isEmpty()){
			dao.addEmployee(e);
		}
		else{
			dao.updateEmployee(e);
		}
		
	}*/
	
	}
}
