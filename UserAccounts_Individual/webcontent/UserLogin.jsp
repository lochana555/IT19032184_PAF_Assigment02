<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.sql.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
<link rel="stylesheet" href="views/bootstrap.min.css">
</head>
<body>
<h1 class="m-3">User Login</h1>
<form method="post" action="userloginvalidation.jsp">
User Name:
<input id="uname" name="uname" type="text" class="form-control form-control-sm">
<br/>
Password:
<input id="password" name="password" type="password" class="form-control form-control-sm">
<br/>
<input type="submit" value="Login" />
</form>

 <a href="UserRegistration.jsp"> To Register </a>
</body>
</html>