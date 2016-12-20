<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Form</title>
</head>
<body>
<form action = "EmployeeController.do" method="post">
<label for="empID">Employee ID</label><input type="text" name="empID" value="<c:out value="${employee.empID}"/>" placeholder="Employee ID"/>
<label for="empName">Employee Name</label><input type="text" name="empName" value="<c:out value="${employee.empName}"/>" placeholder="Employee Name"/>
<label for="empAddress">Employee Address</label><input type="text" name="empAddress" value="<c:out value="${employee.empAddress}"/>" placeholder="Employee Address"/>
<input type="submit" value="submit"/>

</form>
</body>
</html>