<%@ page import="com.example.demo7.domain.Product" %>
<%@ page import="com.example.demo7.domain.Cart" %>
<%@ page import="com.example.demo7.domain.Customer" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demo7.resource.resource" %>
<%@ page import="com.example.demo7.service.cartService"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <a href="logOutServlet">Logout</a>
        <img src="images/logo.png" width=100px>
         <a href="removeAccount.jsp">remove Account</a>
            </nav>
    <h1>Shopping Cart</h1>
</header>
<%
   Cart cart = (Cart) session.getAttribute("cart");
   if(cart != null) {
    request.setAttribute("cart", cart);
    }else {
    cart = new Cart();
    request.setAttribute("cart",cart);
    }

%>
<div id="cart-section">
    <h2>Your Cart:${email}</h2>
    <%
        if (!cart.getCartList().isEmpty()) {
        for(Product c:cart.getCartList()){%>
    <div class="cart-item">
        <img src="<%= c.getImage() %>" alt="<%= c.getName() %>">
        <div>
            <h3><%= c.getName() %>
            </h3>
            <span>Price: R<%= c.getPrice() %>
            </span><br>
            <span>Quantity:</span>
            <span><%=c.getQuantity()%></span>
        </div>

        <form action="removeFromCartServlet" method="get">
                        <button type ="button">+</button>
                         <button type ="button">-</button>

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

            <span>R<%=String.format("%.2f", cart.getTotalPrice())%></span>
        </div>
        <div class="cart-quantity">
            <span>Quantity:</span>
            <span><%=cart.getTotalQuantity()%></span>
        </div>
    </div>
</div>
<form action ="addToCartServlet" method ="GET">
       <input type="hidden" name="action" value="add">
      <input type="hidden" name="action" value="dec">
<a href="mainPage.jsp" class="checkout">Continue Shopping</a><br>
<a href="checkout.jsp" class="checkout">Continue to CheckOut</a><br>
</form>
</body>
</html>
