<%--
  Created by IntelliJ IDEA.
  User: kingsley
  Date: 2023/02/20
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation Account Removed</title>
</head>
<style>
        .navbar {
            background-color: #333;
            color: #fff;
            display: flex;
            justify-content: center;
            padding: 10px 20px;
            align-items: center; /* Center vertically */
            height: 80px;
        }
    </style>
<body>
<nav class="navbar">
    <a href="mainPage.jsp"><img src="images/logo.png" width=100px></a>

</nav>
<h3>We are sad to see you go : ${email}. Your account has been removed</h3>
</body>
</html>
