<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Die</title>
</head>
<body>
	<table border= "1">
		<tr>
			
			<th>
			
				<form action="DieController">
				
					<input type = "submit" name = "btn_new" value = "New"/>
				</form>
			 </th>
			 <th>Id</th>
			 <th>Age</th>
			 <th>Service</th>
			 <th>Enter Date</th>
			  <th>Die Date</th>
			   <th>Result</th>
			
		</tr>
		<c:forEach var="die" items="${dies}">
		
		<tr>
			<td>
				<form action= "DieController">
					<input type = "hidden" name = "id" value= "${die.id}"/>
					<input type = "submit" name= "btn_edit" value= "Edit" />
					<input type = "submit" name= "btn_delete" value= "Delete"/>
				</form>
			</td>
			<td> ${die.id}</td>
			<td> ${die.age}</td>
			<td> ${die.service}</td>
			<td> ${die.enter_date}</td>
			<td> ${die.die_date}</td>
			<td> ${die.result}</td>
			
			
			
		</tr>
		
		</c:forEach>
		
	
	</table>
	<form action="MasterReport">
				
					<input type = "submit" name = "btn_reporte" value = "Reporte"/>
				</form>

</body>
</html>