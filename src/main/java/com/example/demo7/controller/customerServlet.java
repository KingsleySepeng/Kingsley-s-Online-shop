package com.example.demo7.controller;

import com.example.demo7.domain.Admin;
import com.example.demo7.resource.resource;
import com.example.demo7.domain.Customer;
import com.example.demo7.service.adminService;
import com.example.demo7.service.customerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.System.out;


@WebServlet(name = "customerServlet", value = "/customerServlet")
public class customerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        switch (action) {
            case "Log In":
                logIn(request, response);
                break;

            case "Sign Up":
                signUp(request, response);
                break;

            case "Remove Account":
                removeAccount(request, response);
                break;

            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //read products into jsp

    }


    public void signUp(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String dob = request.getParameter("dob");
        String confirmPassword = request.getParameter("confirmPassword");

        String fullName = name + " " + surname;
        HttpSession session = request.getSession();
        session.setAttribute("fullName", fullName);


        request.setAttribute("passwordError", "Passwords do not match");
        request.setAttribute("name", name);
        request.setAttribute("surname", surname);
        request.setAttribute("email", email);
        request.setAttribute("dob", dob);

        if (!password.equals(confirmPassword)) {
            // Passwords don't match, set error message and attribute to be used in the JSP form
            RequestDispatcher dispatcher = request.getRequestDispatcher("signUp.jsp");
            dispatcher.forward(request, response);
        } else {
            Customer customer = new Customer(name, surname, email, password, dob);
//            request.getSession().setAttribute("auth", customer);
            customerService cs = new customerService();
            if (cs.customerExist(email, password)) {
                response.sendRedirect("signUpFailed.jsp");
            } else {
                cs.setCustomers(customer);
//                cs.customerCart(customer);
                RequestDispatcher dispatcher = request.getRequestDispatcher("signUpSuccess.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    public static void logIn(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //get email and password from login page
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        session.setAttribute("email", email);
        session.setAttribute("password", password);
        customerService cs = new customerService();
        Admin admin = new Admin();
        admin.setEmail(email);
        admin.setPassword(password);
        adminService adminService = new adminService();
        if (adminService.checkAdmin(admin)) {
            session.setAttribute("email", email);
            RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
            dispatcher.forward(request, response);
        } else if (cs.loginValid(email, password)) {
            request.getRequestDispatcher("mainPage.jsp").forward(request, response);
            RequestDispatcher dispatcher = request.getRequestDispatcher("mainPage.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("loginFailed.jsp");
            request.setAttribute("email", email);
            request.setAttribute("passEr", "Passwords do not match");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
//                dispatcher.forward(request, response);
        }

    }


    //remove account page
    public static void removeAccount(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String sessionEmail = (String) session.getAttribute("email");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        customerService cs = new customerService();
        if (!password.equals(confirmPassword)) {
            // Passwords don't match, set error message and attribute to be used in the JSP form
            request.setAttribute("passwordErr", "Passwords do not match");
            request.setAttribute("email", email);
            request.setAttribute("password", password);

            RequestDispatcher dispatcher = request.getRequestDispatcher("removeAccount.jsp");
            dispatcher.forward(request, response);

        } else {
            if (cs.customerExist(email, password)) {
                cs.removeCustomer(email, password);
                request.setAttribute("email", email);
                RequestDispatcher dispatcher = request.getRequestDispatcher("accountRemoved.jsp");
                dispatcher.forward(request, response);
                session.removeAttribute(sessionEmail);
                session.invalidate();
            } else {
                response.sendRedirect("removeAccountFailed.jsp");
            }
        }
    }


}



