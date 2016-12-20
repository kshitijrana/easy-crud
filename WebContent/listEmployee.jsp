<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Employees</title>
</head>
<body>
<table border=1>
<thead>
<tr>
<th>Employee ID</th>
<th>Employee Name</th>
<th>Employee Address</th>
<th colspan=2>Action</th>
</tr>
</thead>
<tbody>
<c:forEach items="${employees}" var = "employee">
<tr>
<td><c:out value="${employee.empID }" /></td>
<td><c:out value="${employee.empName }" /></td>
<td><c:out value="${employee.empAddress }" /></td>
<td><a href="EmployeeController.do?action=edit&empID=<c:out value="${employee.empID }"/>">Update</a></td>
<td><a href="EmployeeController.do?action=delete&empID=<c:out value="${employee.empID }"/>">Delete</a></td>
</tr>
</c:forEach>
</tbody>
</table>
<p>
<a href="EmployeeController.do?action=insert">Add another employee</a><br><br>
<a href="index.jsp">Go back</a>
</p>
</body>
</html>