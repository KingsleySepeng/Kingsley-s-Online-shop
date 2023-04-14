package com.example.demo7.controller;
import com.example.demo7.domain.Cart;
import com.example.demo7.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "QuantityIncreaseDecreaseServlet", value = "/QuantityIncreaseDecreaseServlet")
public class QuantityIncreaseDecreaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        PrintWriter out = response.getWriter();
        switch (action) {
            case "increase":
                increaseQuantity(request, response);
                break;

            case "decrease":
                decreaseQuantity(request, response);
                break;
            default:
                break;
        }

    }

    private void decreaseQuantity(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        if (id != null){
            Cart cart = (Cart) request.getSession().getAttribute("cart");
            if (cart != null){
                int productId = Integer.parseInt(id);
                cart.decrementQuantity(productId);
                response.sendRedirect("viewCart.jsp");
            }else {
                response.sendRedirect("viewCart.jsp");
            }
        }
    }

    private void increaseQuantity(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        if (id != null){
            Cart cart = (Cart) request.getSession().getAttribute("cart");
            if (cart != null){
                int productId = Integer.parseInt(id);
                cart.incrementQuantity(productId);
                response.sendRedirect("viewCart.jsp");
            }else {
                response.sendRedirect("viewCart.jsp");
            }
            }
    }

    }


