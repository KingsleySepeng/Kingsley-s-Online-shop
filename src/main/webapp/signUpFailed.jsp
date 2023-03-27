<%--
  Created by IntelliJ IDEA.
  User: kingsley
  Date: 2023/02/20
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up Error</title>
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
<h2>An error has occurred while trying to sign up...</h2>
<h2>Looks like you are already registered, try to log in again</h2>
<a href ="signUp.jsp">Back to Sign up page</a>
</body>
</html>
