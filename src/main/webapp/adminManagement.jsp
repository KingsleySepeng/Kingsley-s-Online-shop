<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demo7.domain.Admin" %>
<%@ page import="com.example.demo7.service.adminService" %>
<html>
<head>
    <title>Admin management</title>
    <style>
            .navbar {
                background-color: #333;
                color: #fff;
                display: flex;
                justify-content: center;
                padding: 10px 20px;
                align-items: center;
                height: 80px;
            }
        </style>
</head>
<body>
<nav class="navbar">
<a href="admin.jsp"><img src="images/logo.png" width=100px></a>
</nav>
<form action = "adminServlet" method="Post">
<div>
<h3>all admins:</h3>
<%
adminService adminService = new adminService();
List<admin> admins = adminService.showAllAdmins();
for(Admin admin: admins) {%>
<h2>admin:<%=admin%></h2>
<input type = "text" name ="email"><button type ="submit" value="remove admin" name ="action">remove admin</button><br><br>
<%}%>
</div>
<label for="email">Email</label><br>
<input type = "text" name ="email"><br>
<label for="adminPassword">Password</label><br>
<input type = "text" name ="password"><br>
<button type = "submit" value="add admin" name ="action">add admin</button>
<button type ="submit" value="show admins" name ="action">show all admins</button>
</form>
</body>
</html>
