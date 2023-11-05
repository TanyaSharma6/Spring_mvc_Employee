<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3> logged in</h3>
<form:form action="view" modelAttribute="employee">
	<form:label path="email">Email:</form:label>
	<form:input path="email" />
	
	<form:label path="password">Password:</form:label>
	<form:password path="password" />
	
	<form:button>Login</form:button>
</form:form>		
</body>
</html>