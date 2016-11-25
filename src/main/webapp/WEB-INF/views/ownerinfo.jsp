<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/homelooks.css">
</head>
<body>
<h1>Input Student Username</h1>
<form name="studentinfo" action="student" method="post"
onsubmit="return validateStudent()" method="post">

Student username: <input type="text" name="studentuser">
<br><br><input type="submit" value="submit">

</form>

<p>
<br><br><br><br><br><br><br>
</p>
<script>

function validateStudent() {
	
	x = document.forms["studentinfo"]["studentuser"].value;
	if (x == "") {
        alert("You need to input a student's username");
        return false;
    }
   
}

</script>

</body>
</html>