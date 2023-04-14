package com.example.demo7.controller;

import com.example.demo7.domain.Product;
import com.example.demo7.service.ProductService;
import com.example.demo7.service.impl.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "productServlet", value = "/productServlet")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();
        List<Product> products = null;
        try {
            products = productService.showProducts();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        HttpSession session = request.getSession();
        session.setAttribute("products", products);
        RequestDispatcher rd = request.getRequestDispatcher("mainPage.jsp");
        rd.forward(request, response);
    }

}