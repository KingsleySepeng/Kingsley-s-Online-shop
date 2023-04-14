<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demo7.domain.Admin" %>
<%@ page import="com.example.demo7.service.impl.AdminServiceImpl" %>
<%@ page import="com.example.demo7.service.impl.CustomerServiceImpl" %>
<%@ page import="com.example.demo7.domain.Customer" %>
<%@ page import="com.example.demo7.service.CustomerService" %>
<html>
<head>
    <title>Admin management</title>
    <style>
        .navbar {
            background-color: #333;
            color: #fff;
            display: flex;
            justify-content: center;
            padding: 10px 20px;
            align-items: center;
            height: 80px;
        }
    </style>
</head>
<body>
<nav class="navbar">
    <a href="admin.jsp"><img src="images/logo.png" width=100px></a>
</nav>
<form action = "adminServlet" method="Post">
    <div>
        <h2>all customers:</h2>
        <%
            CustomerServiceImpl customerService = new CustomerServiceImpl();
            List<Customer> customers = customerService.showAllCustomers();
            for(Customer customer : customers) {%>
        <h3>customer:<%=customer.getEmail()%></h3>
        <%}%>
    </div>
    <div>
        <h2>all admins:</h2>
            <%
                AdminServiceImpl adminServiceImpl = new AdminServiceImpl();
                List<Admin> admins = adminServiceImpl.showAllAdmins();
                for(Admin admin: admins) {%>
            <h3>admin:<%=admin.getEmail()%></h3>
            <%}%>

    </div>
    <input type = "text" name ="email" placeholder="Enter email here">
    <button type ="submit" value="remove_as_admin" name ="action">remove admin</button>
    <button type = "submit" value="change_to_admin" name ="action">add admin</button>

</form>
</body>
</html>
