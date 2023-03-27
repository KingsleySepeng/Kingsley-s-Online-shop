package com.example.demo7.service;

import com.example.demo7.domain.Admin;
import com.example.demo7.resource.adminResource;

import java.io.IOException;
import java.util.List;

public class adminService {

    private List<Admin> admins;

    public List<Admin> getAdmins() {return admins;}

    public void addAdmin(Admin admin) throws IOException {
        adminResource adminResource = new adminResource();

        adminResource.writeAdmin(admin);
    }

    public boolean checkAdmin(Admin admin) throws IOException {
     adminResource adminResource = new adminResource();
     return adminResource.readAdmin(admin);
    }

    public void removeAdmin(String email) throws IOException {
        adminResource adminResource = new adminResource();
        adminResource.removeAdmin(email);
    }

    public void showAllAdmins() throws IOException{
        adminResource adminResource = new adminResource();
        adminResource.readAllAdmins();
    }

    public void addProduct(){}
    public void removeProduct(){}

    public void updatePrice(){}

    public void updateQuantity(){}


}
