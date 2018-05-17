<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Drivers</title>
</head>
<body>
	All drivers:
	<table>
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
				<th></th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${drivers}" var="item">
				<tr>
					<td>${item.getFirstName()}</td>
					<td>${item.getLastName()}</td>
					<td>${item.getAge()}</td>
					<td>
						<form action="/driver/${item.getId()}" method="get">
							<input type="submit" value="edit" name="Submit" />
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/driver/save">Create driver</a>
</body>
</html>