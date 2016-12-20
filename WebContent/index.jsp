<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<a href="EmployeeController.do?action=showEmployees">Show Employees</a><br><br>
<a href="EmployeeController.do?action=insert">Add new employee</a>
<%-- <jsp:forward page="/EmployeeController?action=listEmployee"></jsp:forward> --%>
</body>
</html>