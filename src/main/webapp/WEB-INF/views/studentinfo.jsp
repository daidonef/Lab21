<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Information</title>
<link rel="stylesheet" type="text/css" href="resources/studentinfolooks.css">
</head>
<h1>Student Information</h1>
<body>
<p>Student username: ${student}</p>
<p>Student username and password: ${info}</p>
<p>
<br><br><br><br><br><br><br>
<form name="back" action="owner" method="post" method="post">
<input type="submit" value="Back to Get Other Student's Info">
</form>
</p>
</body>
</html>