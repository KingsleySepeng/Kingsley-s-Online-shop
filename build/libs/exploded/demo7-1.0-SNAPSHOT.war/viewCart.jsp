<%@ page import="com.example.demo7.domain.Product" %>
<%@ page import="com.example.demo7.domain.Cart" %>
<%@ page import="com.example.demo7.domain.Customer" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demo7.resource.resource" %>
<%@ page import="com.example.demo7.service.cartService" %>
<%--
  Created by IntelliJ IDEA.
  User: kingsley
  Date: 2023/02/13
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Customer auth = (Customer) request.getSession().getAttribute("auth");
    if (auth != null) {
        request.setAttribute("auth", auth);
    }
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    List<Cart> cartProduct = null;
    if (cart_list != null) {
        cartService cs = new cartService();
        cartProduct = cs.getCartProducts(cart_list);
        request.setAttribute("cart_list", cart_list);
    }
%>
<html>
<head>
    <title>Cart</title>
    <style>
        #cart-section {
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            padding: 20px;
        }

        #cart-section h2 {
            font-size: 24px;
            margin-bottom: 20px;
        }

        .cart-item {
            display: flex;
            align-items: center;
            margin-bottom: 20px;
        }

        .cart-item img {
            height: 100px;
            margin-right: 20px;
            object-fit: contain;
            width: 100px;
        }

        .cart-item h3 {
            font-size: 18px;
            margin: 0;
        }

        .cart-item p {
            font-size: 16px;
            margin: 0;
        }

        .cart-item button {
            background-color: #f00;
            border: none;
            border-radius: 5px;
            color: #fff;
            cursor: pointer;
            font-size: 16px;
            margin-left: auto;
            padding: 10px 20px;
        }

        .cart-summary {
            display: flex;
            justify-content: space-between;
            margin-top: 20px;
        }

        .cart-total span:first-of-type,
        .cart-quantity span:first-of-type {
            font-weight: bold;
            margin-right: 10px;
        }

        /* Checkout button styles */
        .checkout {
            display: block;
            margin: 10px;
            padding: 10px;
            background-color: #333;
            color: white;
            text-align: center;
            text-decoration: none;
            font-size: 18px;
            font-weight: bold;
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
<header>
    <nav class="navbar">
        <a href="login.jsp">Logout</a></nav>
    <h1>Shopping Cart</h1>
</header>
<div id="cart-section">
    <h2>Your Cart</h2>
    <%
        if (cart_list != null) {
            for (Cart c : cartProduct) {%>
    <div class="cart-item">
        <img src="<%= c.getProductImage() %>" alt="<%= c.getProductName() %>">
        <div>
            <h3><%= c.getProductName() %>
            </h3>
            <p>Price: R<%= c.getPrice() %>
            </p>
        </div>
        <form action="removeCartServlet" method="get">
            <input type="hidden" name="id" value="<%= c.getId() %>">
            <button type="submit" name="action" value="Remove">Remove</button>
        </form>
    </div>
    <%
        }
    } else {%>
    <p>Your cart is empty.</p>
    <%
        }
    %>

    <div class="cart-summary">
        <div class="cart-total">
            <span>Total:</span>
            <%
                double totalPrice = 0.0;
                if (cart_list != null) {
                    for (Cart c : cart_list) {
                        totalPrice += c.getPrice();
                    }
                }%>
            <span>R<%=String.format("%.2f", totalPrice)%></span>
        </div>
        <div class="cart-quantity">
            <span>Quantity:</span>
            <span><%= cart_list != null ? cart_list.size() : "0" %></span>
        </div>
    </div>
</div>


<input type="submit" class="checkout" value="Continue To Check Out" name="action">
<a href="mainPage.jsp" class="checkout">Continue Shopping</a><br>
</form>
</body>
</html>
