package com.example.demo7.service;

import com.example.demo7.domain.Admin;
import com.example.demo7.domain.Product;
import com.example.demo7.resource.AdminResource;
import com.example.demo7.resource.impl.AdminResourceImpl;

import java.sql.SQLException;
import java.util.List;

public interface AdminService {

    boolean checkAdmin(Admin admin);

    void addAdmin(String email);

    void removeAdmin(String email) ;

    List<Admin> showAllAdmins();

    void updateProduct(int productId, String newName, double newPrice, int newQuantity);

    void addProduct(Product product);

    boolean productExist(String name);

    void removeProduct(int productId);

}
