<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<link rel="stylesheet" href="views/bootstrap.min.css">
</head>
<body>
<h1 class="m-3">Admin Login</h1>
<form method="post" action="adminloginvalidation.jsp">
User Name:
<input id="uname" name="uname" type="text" class="form-control form-control-sm">
<br/>
Password:
<input id="password" name="password" type="password" class="form-control form-control-sm">
<br/>
<input type="submit" value="Login" />
</form>

 <a href="AdminRegistration.jsp"> To Register </a>
</body>
</html>