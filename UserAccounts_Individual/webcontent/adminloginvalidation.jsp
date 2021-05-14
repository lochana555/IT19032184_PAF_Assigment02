<%@ page import ="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Profile</title>
<link rel="stylesheet" href="views/bootstrap.min.css">
</head>
<body>
<%
    String uname = request.getParameter("uname");    
    String password = request.getParameter("password");
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user_account_service", "root", "");
    Statement st = con.createStatement();
    ResultSet rs;
    rs = st.executeQuery("select * from admin_account where uname='" + uname + "' and password='" + password + "'");
    if (rs.next()) {
        session.setAttribute("uname", uname);
        out.println("Welcome Admin "+uname);
       
    } else {
        out.println("Invalid User");
    }
%>

</body>
</html>