<%@ page import = "model.AdminAccount" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Registration</title>
<link rel="stylesheet" href="views/bootstrap.min.css">
<script src="components/jquery-3.2.1.min.js"></script>
<script src="components/AdminRegistration.js"></script>
</head>
<body>
<form id="formAdminRegistration" name="formAdminRegistration" method="post" action="AdminRegistration.jsp">
<h1 class="m-3">Admin Account Management</h1>
<br/>

User Name:
<input id="uname" name="uname" type="text" class="form-control form-control-sm">
<br/>
Password:
<input id="password" name="password" type="password" class="form-control form-control-sm">
<br/>
 Email Address:
<input id="email" name="email" type="text" class="form-control form-control-sm">
<br/>
 Age:
<input id="age" name="age" type="text" class="form-control form-control-sm">
<br/>
Address:
<input id="address" name="address" type="text" class="form-control form-control-sm">
<br/>

<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">
<input type="hidden" id="hidUIDSave" name="hidUIDSave" value="">
</form>

<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>
	
	<br>
	<div id="divAdminGrid">
	<%
		AdminAccount uObj = new AdminAccount();
		out.print(uObj.readAdminDetails());
	%>
	</div>
	
</body>
</html>