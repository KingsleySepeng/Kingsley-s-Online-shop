package com.example.demo7.resource;

import com.example.demo7.domain.Admin;
import com.example.demo7.domain.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface AdminResource {

    List<Admin> readAllAdmins() ;

    void writeAdmin(String email) ;

    void editProduct(int productId, String newName, double newPrice, int newQuantity) ;

    void removeAdmin(String email);

    boolean readAdmin(Admin admin) ;

    void addNewProduct(Product product) throws SQLException, ClassNotFoundException ;

    boolean readProducts(String name) ;

    void removeProduct(int productId) ;
}
