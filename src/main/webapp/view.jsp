<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<table border=2 cellpadding="12px">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Address</th>
		<th>Phone no.</th>
		<th>Email</th>
		<th>Password</th>
		<th>Delete</th>
		<th>Edit</th>
	</tr>
	<c:forEach var="employee" items="${elist}">
		<tr>
		
			<td>${employee.id}</td>
			<td>${employee.name}</td>
			<td>${employee.address}</td>
			<td>${employee.phone}</td>
			<td>${employee.email}</td>
			<td>${employee.password}</td>
			<td><a href="deleteemployee?id=${employee.id}">Delete</a></td>
			<td><a href="edit?id=${employee.id}">Edit</a></td>
		</tr>
		
	</c:forEach>
		
</table>

</body>
</html>