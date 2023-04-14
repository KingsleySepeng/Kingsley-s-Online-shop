package com.example.demo7.service.impl;

import com.example.demo7.domain.Admin;
import com.example.demo7.domain.Product;
import com.example.demo7.resource.AdminResource;
import com.example.demo7.resource.impl.AdminResourceImpl;
import com.example.demo7.service.AdminService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminServiceImpl implements AdminService {

    private List<Admin> admins;

    private List<Product> productList;

    public AdminServiceImpl() {
        this.productList = new ArrayList<>();
    }

    AdminResource adminResource = new AdminResourceImpl();

    public List<Admin> getAdmins() {return admins;}

    @Override
    public boolean checkAdmin(Admin admin)  {
        return adminResource.readAdmin(admin);
    }

    @Override
    public void addAdmin(String email){
        adminResource.writeAdmin(email);
    }

    @Override
    public void removeAdmin(String email) {
        adminResource.removeAdmin(email);
    }

    @Override
    public List<Admin> showAllAdmins(){
        return adminResource.readAllAdmins();
    }

    @Override
    public void updateProduct(int productId, String newName, double newPrice, int newQuantity){
        adminResource.editProduct(productId, newName, newPrice, newQuantity);

    }

    @Override
    public void addProduct(Product product){
        this.productList.add(product);
        AdminResource adminResource = null;
        try {
            adminResource =  new AdminResourceImpl();
            adminResource.addNewProduct(product);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean productExist(String name){
        return adminResource.readProducts(name);

    }

    @Override
    public void removeProduct(int productId) {
        adminResource.removeProduct(productId);
    }


}
