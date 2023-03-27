<%@ page import="com.example.demo7.domain.Customer" %><%--
  Created by IntelliJ IDEA.
  User: kingsley
  Date: 2023/02/21
  Time: 09:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Sing up page</title>
    <style>
        .has-error input.form-input {
            border: 1px solid red;
        }

        .has-error label.form-label {
            color: red;
        }

        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        .form-container {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px #c2c2c2;
            width: 500px;
            margin: 100px auto;
        }

        .form-header {
            text-align: center;
            margin-bottom: 20px;
        }

        .form-header h2 {
            font-size: 36px;
            font-weight: bold;
            color: #5e5e5e;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-label {
            font-size: 18px;
            font-weight: bold;
            color: #5e5e5e;
            display: block;
            margin-bottom: 10px;
        }

        .form-input {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border-radius: 5px;
            border: 1px solid #c2c2c2;
        }

        .form-submit {
            background-color: #4CAF50;
            color: #ffffff;
            padding: 10px 20px;
            border-radius: 5px;
            border: none;
            cursor: pointer;
            font-size: 18px;
            font-weight: bold;
            width: 100%;
            margin-top: 20px;
        }

        .form-submit:hover {
            background-color: #3e8e41;
        }

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
</head>
<body>
<body>
        <%
          Customer signedUp = (Customer) request.getSession().getAttribute("auth");
         if (signedUp == null) { %>
      <nav class="navbar">
          <a href="login.jsp">Login in</a>
          <img src="images/logo.png" width=100px>
      </nav>
        <% } %>

<div class="form-container">
    <div class="form-header">
        <h2>Sign up page</h2>
    </div>
    <form action="customerServlet" method="post">
        <div class="form-group">
            <label class="form-label" for="name">Name</label>
            <input type="text" class="form-input" id="name" name="name" value="${not empty name ? name : ''}" required><br>

            <label class="form-label" for="surname">Surname</label>
            <input type="text" class="form-input" id="surname" name="surname" value="${not empty surname ? surname : ''}" required><br>

            <label class="form-label" for="email">Email</label>
            <input type="email" class="form-input" id="email" name="email" value="${not empty email ? email : ''}" required><br>

            <label class="form-label" for="DOB">DOB</label>
            <input type="Date" class="form-input" id="dob" name="dob" value="${not empty dob ? dob : ''}" required><br>
        </div>
        <% //toggle password
            String showPassword = request.getParameter("showPassword");
            String passwordType = "password";
            if (showPassword != null) {
                passwordType = "text";
            }
        %>
        <div class="form-group ">
            <label class="form-label" for="password">Password</label>
            <input type="<%=passwordType%>" class="form-input" id="password" name="password" required><br>
              <div class="form-group <%= request.getAttribute("passwordError") != null ? "has-error" : "" %>"><br>
              <label class="form-label" for="confirmPassword">Confirm password</label>
              <input type="<%=passwordType%>" class="form-input <%= request.getAttribute("passwordError") != null ? "has-error" : "" %>" id="confirmPassword" name="confirmPassword" required>
             <input type="checkbox" id="showConfirmPassword">show Password
        </div>
            </div>
            <input type="submit" class="form-submit" value="Sign Up" name="action">
        </div>
    </form>
</div>
</body>
</html>
