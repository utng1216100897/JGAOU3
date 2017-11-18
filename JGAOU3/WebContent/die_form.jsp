<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Die Form</title>
</head>
<body>
	<form action="DieController">
		<label>Age:</label><br>
		<input type = "text" name= "age" value = "${die.age}" /><br>
		
		<label>Service:</label><br>
		<input type = "text" name= "service" value = "${die.service}" /><br>
		
		<label>Enter date:</label><br>
		<input type = "text" name= "enter_date" value = "${die.enter_date}" /><br>
		
		<label>die date:</label><br>
		<input type = "text" name= "die_date" value = "${die.die_date}" /><br>
		
		<label>result:</label><br>
		<input type = "text" name= "result" value = "${die.result}" /><br>
		
		
		<input type = "submit" name = "btn_save" id="btn_save" value = "Save"/>
	</form>
</body>
</html>