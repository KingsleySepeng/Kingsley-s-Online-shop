
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Checkout Page</title>
</head>
<style>
        .navbar {
            background-color: #333;
            color: #fff;
            display: flex;
            justify-content: space-between;
            padding: 10px 20px;
        }

        .navbar a {
            color: #fff;
            text-decoration: none;
            margin-right: 20px;
        }
    </style>
<body>
<h2>Welcome admin ${email}, manage the website here</h2>
<nav class="navbar">
    <a href="logOutServlet">Logout</a>
     <a href="adminManagement.jsp">Manage admins</a>
         <a href="stockManagement.jsp">Update stock</a>
</nav>
</body>
</html>
