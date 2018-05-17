<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Students</title>
</head>
<body>

	All Students:
	<table>
		<thead>
			<tr>
				<th>Ime</th>
				<th>Prezime</th>
				<th>Pol</th>
				<th>God Rodjenja</th>
				<th>Sport</th>
				<th>Hobi</th>
				<th>Index</th>
			</tr>
		</thead>
		<tbody>
		
			<c:forEach items="${students}" var="item">
				<tr>
					<td>${item.getIme()}</td>
					<td>${item.getPrezime()}</td>
					<td>${item.getPol()}</td>
					<td>${item.getGodRodjenja()}</td>
					<td>${item.getSport()}</td>
					<td>${item.getHobi()}</td>
					<td>${item.getIndex()}</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>

</body>
</html>