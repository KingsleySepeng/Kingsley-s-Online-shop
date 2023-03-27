package com.example.demo7.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "logOutServlet", value = "/logOutServlet")
public class logOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String)session.getAttribute("email");
        try (PrintWriter out = response.getWriter()) {
            if (email!= null){
                session.removeAttribute("email");
                request.getSession().removeAttribute("email");
                session.invalidate();
                request.getSession().removeAttribute("cart");
                response.sendRedirect("login.jsp");
            }else{
                out.println("logout failed");
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}