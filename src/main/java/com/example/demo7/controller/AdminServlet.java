package com.example.demo7.controller;

import com.example.demo7.domain.Product;
import com.example.demo7.service.AdminService;
import com.example.demo7.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "adminServlet", value = "/adminServlet")
public class AdminServlet extends HttpServlet {
    AdminService adminService = new AdminServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        PrintWriter out = response.getWriter();
        switch (action) {
            case "change_to_admin":
                addAdmin(request, response);
                out.println("admin added");
                break;

            case "remove_as_admin":
                removeAdmin(request, response);
                out.println("admin removed");
                break;

            case "show admins":
                out.println("show admins");
                showAdmins(request, response);
                break;

            case "update product":
                updateProduct(request, response);
                out.println("product updated");
                break;

            case "add product":
                addProduct(request, response);
                out.println("product added");
                break;

            case "remove product":
                removeProduct(request, response);
                out.println("product removed");
                break;

            default:
                break;
        }

    }

    public void addAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        adminService.addAdmin(email);

    }

    public void removeAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        adminService.removeAdmin(email);
    }

    public void showAdmins(HttpServletRequest request, HttpServletResponse response) throws IOException {
        adminService.showAllAdmins();
    }

    public void addProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String imageFile = request.getParameter("new_product_image");
        String newImage = "images\\" + imageFile;
        String newName = request.getParameter("new_product_name");
        Double newPrice = Double.valueOf(request.getParameter("new_product_price"));
        int newQuantity = Integer.parseInt(request.getParameter("new_product_quantity"));

        Product  newProduct = new Product(0, newName, newImage, newPrice, newQuantity);
//        AdminServiceImpl adminServiceImpl = new AdminServiceImpl();
        if (adminService.productExist(newName)){
            response.sendRedirect("addNewProductFailed.jsp");
        }else {
            adminService.addProduct(newProduct);
            response.sendRedirect("newProductAddedSuccess.jsp");

        }
    }

    public void removeProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int productId = Integer.parseInt(request.getParameter("id"));
//        AdminServiceImpl adminServiceImpl = new AdminServiceImpl();
        adminService.removeProduct(productId);
        response.sendRedirect("newProductAddedSuccess.jsp");


    }

    public void updateProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int productId = Integer.parseInt(request.getParameter("id"));
        System.out.println("XXXXXXX" + productId);
        String newName = request.getParameter("name");
        double newPrice = Double.parseDouble(request.getParameter("price"));
        int newQuantity = Integer.parseInt(request.getParameter("quantity"));
//        AdminServiceImpl adminServiceImpl = new AdminServiceImpl();
        adminService.updateProduct(productId, newName, newPrice, newQuantity);
        response.sendRedirect("newProductAddedSuccess.jsp");

    }

}
