<%@ page import="com.example.demo7.domain.Product" %>
<%@ page import="com.example.demo7.resource.resource" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demo7.domain.Customer" %>
<%@ page import="com.example.demo7.service.productService" %>
<%@ page import="com.example.demo7.resource.productResource" %>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: kingsley--%>
<%--  Date: 2023/02/13--%>
<%--  Time: 12:21--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
    <style>
        .container {
            width: 80%;
            margin: 0 auto;
            text-align: center;
        }

        .product {
            display: inline-block;
            margin: 10px;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 10px;
            text-align: left;
            width: 200px;
        }

        .product img {
            width: 100%;
            height: 30%;
            border-radius: 10px 10px 0 0;
        }

        .product h3 {
            margin: 10px 0;
        }

        .product p {
            margin: 0;
            font-weight: bold;
            color: green;
        }

        .banner {
            background-color: #333;
            color: #fff;
            width: 100%;
            height: 200px;
            display: flex;
            align-items: center;
            justify-content: center;
            text-align: center;
        }

        .banner h1 {
            font-size: 36px;
            margin: 0;
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
            .cart {
          position: relative;
          display: inline-block;
        }

        .badge {
          position: absolute;
          top: -10px;
          right: -10px;
          background-color: red;
          color: white;
          padding: 5px;
          border-radius: 50%;
          font-size: 14px;
    </style>
</head>
<body>
        <%
        String email = (String) session.getAttribute("email");
         if (email == null) { %>
             <nav class="navbar">
                  <a href="login.jsp">Login</a>
                  <a href="signUp.jsp">Sign up</a>
                  </nav>
        <% } else{ %>
         <nav class="navbar">
          <a href="logOutServlet">Log out</a><br>
          <div class="cart">
                   <a href="viewCart.jsp">Cart</a>
                  <span class="badge">3</span>
              </div>
              </nav>
        <%}%>

<div class="banner">
    <img src="images/logo.png" width=300px>
</div>

<div class="container">
    <h2>Check out our latest products:${email}</h2>
    <%
//      List<Product> products = (List<Product>) request.getSession().getAttribute("products");
        productService pds = new productService();
        List<Product> products = pds.showProducts();
        if (products != null) {
            for (Product pd : products) { %>
    <div class="product">
        <img src="<%=pd.getImage()%>" alt="image">
        <h3><%=pd.getName()%>
        </h3>
        <p>R<%=pd.getPrice() %>
        </p><span>${added}</span>
        <form action="addToCartServlet" method="GET">
            <input type="submit" class="Add-To-Cart" value="add to cart" id="<%=pd.getId()%>">
            <input type="hidden" name="id" value="<%=pd.getId()%>">
            <input type="hidden" name="getImage" value="<%=pd.getImage()%>">
            <input type="hidden" name="getName" value="<%=pd.getName()%>">
            <input type="hidden" name="getPrice" value="<%=pd.getPrice()%>">
             <input type="hidden" name="getQuantity" value="<%=pd.getQuantity()%>">
            <input type ="hidden" name ="email" value="<%=session.getAttribute("email")%>">
        </form>
    </div>
    <% }
    }%>
</div>
</body>
</html>
