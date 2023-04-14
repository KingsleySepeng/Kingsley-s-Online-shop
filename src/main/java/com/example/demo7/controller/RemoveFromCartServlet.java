package com.example.demo7.controller;

import com.example.demo7.domain.Cart;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "removeFromCartServlet", value = "/removeFromCartServlet")
public class RemoveFromCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            String id = request.getParameter("id");
            if (id != null) {
               Cart cart = (Cart) request.getSession().getAttribute("cart");
                if (cart != null) {
                    int productId = Integer.parseInt(id);
                    cart.removeFromCart(productId);
                    response.sendRedirect("viewCart.jsp");
                }
            } else {
                response.sendRedirect("viewCart.jsp");
            }
        }
    }
}
