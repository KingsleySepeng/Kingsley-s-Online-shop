package com.example.demo7.controller;

import com.example.demo7.domain.Cart;
import com.example.demo7.domain.Customer;
import com.example.demo7.domain.Product;
import com.example.demo7.service.cartService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import static java.lang.System.out;

@WebServlet(name = "addToCartServlet", value = "/addToCartServlet")
public class addToCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        if (email == null) {
            response.sendRedirect("login.jsp");
        } else {
            response.setContentType("text/html");
            try (PrintWriter out = response.getWriter()) {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("getProductName");
                String photo = request.getParameter("getProductImage");
                double unitPrice = Double.parseDouble(request.getParameter("getPrice"));

                Cart cartSession = (Cart) session.getAttribute("cart");
                if (cartSession == null) {
                    Cart cart = new Cart(); //anonymous object
                    cart.setCartEmail(email);
                    cart.addProductToCart(new Product(id, name, photo, unitPrice, 1));
                    session.setAttribute("cart", cart);
                    request.setAttribute("added", "added to your cart");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("mainPage.jsp");
                    dispatcher.forward(request, response);
                } else {
                    boolean exists = false;
                    for (Product product : cartSession.getCartList()) {
                        if (product.getId() == id) {
                            product.setQuantity((product.getQuantity()) + 1);
                            product.setPrice((product.getPrice()+ product.getPrice()));
                            request.setAttribute("added", "added to your cart");
                            exists = true;
                            response.sendRedirect("viewCart.jsp");
                        }
                    }
                    if (!exists) {

                        cartSession.addProductToCart(new Product(id, name, photo, unitPrice, 1));

                        request.setAttribute("added", "added to your cart");
                        RequestDispatcher dispatcher = request.getRequestDispatcher("mainPage.jsp");
                        dispatcher.forward(request, response);
                    }

                    String action = request.getParameter("action");
                    switch (action) {
                        case "add":

                            break;

                        case "dec":

                            break;
                    }
                    cartService cs = new cartService();
                    cs.addProductsIntoCart(cartSession);
                    session.setAttribute("cart", cartSession);
                    request.setAttribute("added", "added to your cart");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("mainPage.jsp");
                    dispatcher.forward(request, response);

                }
            } catch (ServletException e) {
               out.println("could not add to cartServlet");
            }
        }
    }
}