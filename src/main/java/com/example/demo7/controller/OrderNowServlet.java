package com.example.demo7.controller;

import com.example.demo7.domain.Cart;
import com.example.demo7.service.CartService;
import com.example.demo7.service.impl.CartServiceImpl;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "OrderNowServlet", value = "/OrderNowServlet")
public class OrderNowServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        CartService cartService = new CartServiceImpl();
        Cart cartListSession = (Cart) session.getAttribute("cart");
        cartService.orderNow(cartListSession);
        session.removeAttribute("cart");
        response.sendRedirect("orderSent.jsp");

    }
}
