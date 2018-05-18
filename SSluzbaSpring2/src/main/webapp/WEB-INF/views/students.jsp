<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Students</title>
</head>
<body>
	All students:
	<table id="students">
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Index</th>
				<th></th>
			</tr>
		</thead>

		<tbody>
		</tbody>
		<%-- 		<c:forEach items="${students}" var="item"> --%>
		<!-- 			<tr> -->
		<%-- 				<td>${item.getFirstName()}</td> --%>
		<%-- 				<td>${item.getLastName()}</td> --%>
		<%-- 				<td>${item.getAge()}</td> --%>
		<!-- 				<td> -->
		<%-- 					<form action="/students/${item.getId()}" method="get"> --%>
		<!-- 						<input type="submit" value="edit" name="Submit" /> -->
		<!-- 					</form> -->
		<!-- 				</td> -->
		<!-- 			</tr> -->
		<%-- 		</c:forEach> --%>
	</table>
	<form action="/students/add" method="get">
		<input type="submit" value="insert" name="Submit" />
	</form>
	Quick insert:
	<input type="text" id="quickInsertFN" placeholder="first name" />
	<input type="text" id="quickInsertLN" placeholder="last name" />
	<input type="text" id="quickInsertAG" placeholder="age" />
	<input type="button" value="insert" id="quickInsert" />
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script>
		jQuery(document).ready(function() {
			var table = $('#students tbody');
			$.ajax({
				type : "GET",
				url : "/api/student/all",
				success : function(students) {
					students.forEach(function(student) {
						table.append(prepareTableData(student));
						prepareDeleteWithJavascript();
					});

				},
				failure : function(e) {
					alert("NOT ADDED!");
				},
				contentType : "application/json; charset=utf-8"
			});

			$("#quickInsert").on('click', function() {
				var data = {
					firstName : $("#quickInsertFN").val(),
					lastName : $("#quickInsertLN").val(),
					age : $("#quickInsertAG").val()
				};

				$.ajax({
					type : "POST",
					url : "/api/student/save",
					data : JSON.stringify(data),
					success : function(student) {
						table.append(prepareTableData(student));
						prepareDeleteWithJavascript();
					},
					failure : function(e) {
						alert("NOT ADDED!");
					},
					contentType : "application/json; charset=utf-8"
				});

			});

		});
		function prepareTableData(data) {
			var html = "<tr>";
			html = html + "<td>" + data.firstName + "</td>";
			html = html + "<td>" + data.lastName + "</td>";
			html = html + "<td>" + data.age + "</td>";
			html = html
					+ "<td><button type='button' value='" + data.id + "'>delete</button><td>";
			html = html + "</tr>";
			return html;
		}

		// 		function deleteStudent()
		function prepareDeleteWithJavascript() {
			var buttonsForDelete = document.getElementsByTagName('button');
			Array.from(buttonsForDelete).forEach(function(element) {
				element.addEventListener('click', function(){
					var request = new XMLHttpRequest();
					request.open("DELETE", "http://localhost:8080/api/student/remove/" + element.getAttribute('value'));
					request.send();
					request.onreadystatechange = function(){
						if(request.status === 200) {
						    var selectedElement = document.querySelector('button[value="' + element.getAttribute('value') + '"]')
						    selectedElement.parentElement.parentElement.remove();
						}
					}
				});
				
			});
		}
		
	</script>
</body>
</html>