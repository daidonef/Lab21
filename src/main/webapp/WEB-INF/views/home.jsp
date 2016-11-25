<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="resources/homelooks.css">
</head>
<body>
<h1>
	This Your Information and Class 
</h1>

<p>Your first name: ${firstname}</p>
<p>Your last name: ${lastname}</p>
<p>Your full name: ${fullname}</p>
<p>Your username: ${username1}</p>
<p>Your email: ${email}</p>
<p>Your Class: ${dojo}</p>
<p>Classes you have Taken: 
<ul>
	<c:forEach var="fr" items="${passdojo}">
		<li>${ fr }</li>
	</c:forEach>
</ul>
</p>
</body>
</html>
