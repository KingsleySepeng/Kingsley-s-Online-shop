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
<%
    Customer auth = (Customer) request.getSession().getAttribute("auth");
    if (auth != null) {
        request.setAttribute("auth", auth);
    }%>
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
    </style>
</head>
<body>

<nav class="navbar">
    <a href="logOutServlet">Logout</a>
    <a href="viewCart.jsp">Cart</a>
</nav>
<div class="banner">
    <h1>Welcome: Valentino's flower shop</h1>
</div>

<div class="container">
    <h2>Check out our latest products:</h2>
    <%
//      List<Product> products = (List<Product>) request.getSession().getAttribute("products");
        productService pds = new productService();
        List<Product> products = pds.showProducts();
        if (products != null) {
            for (Product pd : products) { %>
    <div class="product">
        <img src="<%=pd.getProductImage()%>" alt="image">
        <h3><%=pd.getProductName()%>
        </h3>
        <p><%=pd.getPrice() %>
        </p>
        <form action="cartServlet" method="GET">
            <input type="submit" class="Add-To-Cart" value="<%=pd.getProductName()%>" id="<%=pd.getId()%>">
            <input type="hidden" name="id" value="<%=pd.getId()%>">
            <input type="hidden" name="getProductImage" value="<%=pd.getProductImage()%>">
            <input type="hidden" name="getProductName" value="<%=pd.getProductName()%>">
            <input type="hidden" name="getPrice" value="<%=pd.getPrice()%>">
        </form>
    </div>
    <% }
    }%>
</div>
</body>
</html>
