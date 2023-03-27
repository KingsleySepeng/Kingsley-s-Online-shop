
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Checkout Page</title>
</head>
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
<body>
<nav class="navbar">
    <a href="logOutServlet">Logout</a>
   <a href="mainPage.jsp"><img src="images/logo.png" width=100px></a>
    <a href="viewCart.jsp">Cart</a>
</nav>
<h2>Thank you for purchasing from us...${email} here is your invoice of your order</h2>
<div id="cart-section">
    <h2>Your Order:${fullName}</h2>
    <div class="cart-item">
        <img src="" alt="">
        <div>
            <h3>
            </h3>
            <span>Price: R
            </span><br>
            <span>Quantity:</span>
            <span></span>
        </div>
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

            <span>R ></span>
        </div>
        <div class="cart-quantity">
            <span>Quantity:</span>
            <span></span>
        </div>
    </div>
</div>
<form action ="" method ="GET">
<a href="orderSent.jsp" class="checkout">Submit order</a><br>
</form>
</body>
</html>
