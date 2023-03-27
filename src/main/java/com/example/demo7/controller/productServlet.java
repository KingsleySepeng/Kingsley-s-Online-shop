package com.example.demo7.controller;

import com.example.demo7.domain.Product;
import com.example.demo7.service.productService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "productServlet", value = "/productServlet")
public class productServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        productService pds = new productService();
        List<Product> products = pds.showProducts();
        HttpSession session = request.getSession();
        session.setAttribute("products", products);
        RequestDispatcher rd = request.getRequestDispatcher("mainPage.jsp");
        rd.forward(request, response);
    }

}