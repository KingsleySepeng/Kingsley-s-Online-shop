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
<nav class="navbar">
    <a href="logOutServlet">Logout</a>
     <img src="images/logo.png" width=100px>
    <a href="viewCart.jsp">Cart</a>
</nav>
<%   %>
<h2>Thank you for signing up...${fullName} please follow the link to the login page</h2>
<a href="login.jsp">Go to Login page</a>
</body>
</html>