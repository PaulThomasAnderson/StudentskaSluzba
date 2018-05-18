<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<spring:url value="/students/save" var="addStudent" />
	<form:form action="${addStudent}" method="post" modelAttribute="student">
		<spring:bind path="id">
			<form:hidden path="id"/>
		</spring:bind>
		<spring:bind path="firstName">
			<form:input path="firstName" type="text" />
		</spring:bind>
		<spring:bind path="lastName">
			<form:input path="lastName" type="text" />
		</spring:bind>
		<spring:bind path="age">
			<form:input path="age" type="text" />
		</spring:bind>
		<input type="submit" value="Save" />
	</form:form>
</body>
</html>