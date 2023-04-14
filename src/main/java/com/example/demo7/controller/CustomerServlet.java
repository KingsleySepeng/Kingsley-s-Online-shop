package com.example.demo7.controller;

import com.example.demo7.domain.Admin;
import com.example.demo7.domain.Customer;
import com.example.demo7.service.CustomerService;
import com.example.demo7.service.impl.AdminServiceImpl;
import com.example.demo7.service.impl.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "customerServlet", value = "/customerServlet")
public class CustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void signUp(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException, ClassNotFoundException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String dob = request.getParameter("dob");
        boolean isAdmin = false;
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
            Customer customer = new Customer(0,name, surname, email, password, dob, isAdmin);
//            request.getSession().setAttribute("auth", customer);
            CustomerService customerService = new CustomerServiceImpl();
            if (customerService.customerExist(email, password)) {
                response.sendRedirect("signUpFailed.jsp");
            } else {
                customerService.setCustomers(customer);
//                cs.customerCart(customer);
                RequestDispatcher dispatcher = request.getRequestDispatcher("signUpSuccess.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    public static void logIn(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException, ClassNotFoundException {
        //get email and password from login page
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();
        session.setAttribute("email", email);
        session.setAttribute("password", password);

        CustomerService customerService = new CustomerServiceImpl();

        Admin admin = new Admin();
        admin.setEmail(email);
        admin.setPassword(password);
        AdminServiceImpl adminServiceImpl = new AdminServiceImpl();

        if (adminServiceImpl.checkAdmin(admin)) {
            session.setAttribute("email", email);
            RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
            dispatcher.forward(request, response);
        } else if (customerService.customerExist(email, password)) {
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
    public static void removeAccount(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException, ClassNotFoundException {
        HttpSession session = request.getSession();
        String sessionEmail = (String) session.getAttribute("email");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        if (!password.equals(confirmPassword)) {
            // Passwords don't match, set error message and attribute to be used in the JSP form
            request.setAttribute("passwordErr", "Passwords do not match");
            request.setAttribute("email", email);
            request.setAttribute("password", password);

            RequestDispatcher dispatcher = request.getRequestDispatcher("removeAccount.jsp");
            dispatcher.forward(request, response);


        } else {
            CustomerService customerService = new CustomerServiceImpl();
            if (customerService.customerExist(email, password)) {
                customerService.removeCustomer(email, password);
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



