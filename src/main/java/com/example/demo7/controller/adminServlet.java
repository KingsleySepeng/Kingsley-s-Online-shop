package com.example.demo7.controller;

import com.example.demo7.domain.Admin;
import com.example.demo7.service.adminService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "adminServlet", value = "/adminServlet")
public class adminServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        PrintWriter out = response.getWriter();
        switch (action) {
            case "add admin":
                addAdmin(request, response);
                out.println("admin added");
                break;

            case "remove admin":
                removeAdmin(request, response);
                out.println("admin removed");
                break;

            case "show admins":
                out.println("show admins");
                showAdmins(request, response);
                break;

            case "update price":
                updatePrice(request, response);
                break;

            case "update quantity ":
                updateQuantity(request,response);
                break;

            case "Add Product":
                addProduct(request, response);
                break;

            case "Remove Product":
                removeProduct(request, response);
                break;

            default:
                break;
        }

    }

    public void addAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = (String) request.getAttribute("email");
        String password = (String) request.getAttribute("password");
        Admin admin = new Admin();
        HttpSession session = request.getSession();
        session.setAttribute("email", email);
        session.setAttribute("password", password);
        adminService adminService = new adminService();
        adminService.addAdmin(admin);
    }

    public void removeAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        adminService adminService = new adminService();
        adminService.removeAdmin(email);
    }

    public void showAdmins(HttpServletRequest request, HttpServletResponse response) throws IOException {
        adminService adminService = new adminService();
        adminService.showAllAdmins();
    }

    public void addProduct(HttpServletRequest request, HttpServletResponse response) {

    }

    public void removeProduct(HttpServletRequest request, HttpServletResponse response) {

    }

    public void updatePrice(HttpServletRequest request, HttpServletResponse response) {

    }

    public void updateQuantity(HttpServletRequest request, HttpServletResponse response) {

    }
}
