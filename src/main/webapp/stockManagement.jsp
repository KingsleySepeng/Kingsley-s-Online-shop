<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.demo7.service.productService" %>
<%@ page import="com.example.demo7.domain.Product" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>stock management</title>
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

        </style>
<body>
<nav class="navbar">
<a href="admin.jsp"><img src="images/logo.png" width=100px></a>
</nav>
  <div class="container">
      <h2>Inventory:${email}</h2>
      <%
  //      List<Product> products = (List<Product>) request.getSession().getAttribute("products");
          productService pds = new productService();
          List<Product> products = pds.showProducts();
          if (products != null) {
              for (Product pd : products) { %>
          <form action="adminServlet" method="GET">
      <div class="product">
          <img src="<%=pd.getImage()%>" alt="image">
          <input type="text" value="<%=pd.getName()%>">
          <input type="text" value="<%=pd.getPrice() %>">
          <input type="text" value="<%=pd.getQuantity()%>">
              <input type="submit" value="update product" id="<%=pd.getId()%>">
              <input type="submit" value="remove product" id="<%=pd.getId()%>">
              <input type="hidden" name="id" value="<%=pd.getId()%>">
              <input type="hidden" name="getImage" value="<%=pd.getImage()%>">
              <input type="hidden" name="getName" value="<%=pd.getName()%>">
              <input type="hidden" name="getPrice" value="<%=pd.getPrice()%>">
               <input type="hidden" name="getQuantity" value="<%=pd.getQuantity()%>">
              <input type ="hidden" name ="email" value="<%=session.getAttribute("email")%>">
      </div>
      <% }
      }%>
      <div class = "product">
      <label for="product">Add a new product</label>
      <input type="file" id = "product" name="product" id = "img">
      <label for="product">name</label>
       <input type="text" name="new product name">
       <label for="product">price</label>
                <input type="text" name ="new product price">
                <label for="product">quantity</label>
                <input type="text" name="new product quantity">
          </form>
            </div>
        </div>
</body>
</html>
