<%--
  Created by IntelliJ IDEA.
  User: kingsley
  Date: 2023/02/20
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
<nav class="navbar">
    <a href="logOutServlet">Logout</a>
     <img src="images/logo.png" width=100px>
    <a href="viewCart.jsp">Cart</a>
</nav>
<h2>There was an error when you were trying to log in</h2>
<h2>You either are not registered or you entered incorrect details</h2>
<a href="login.jsp">Back to Login page</a>
</body>
</html>
