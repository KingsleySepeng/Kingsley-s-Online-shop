package com.example.demo7.resource.impl;

import com.example.demo7.database_dao.DataBaseManager;
import com.example.demo7.domain.Admin;
import com.example.demo7.domain.Product;
import com.example.demo7.resource.AdminResource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminResourceImpl implements AdminResource {
    private DataBaseManager dataBase;
    private String query;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;


    public AdminResourceImpl() {
        try {
            this.dataBase = new DataBaseManager();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Admin>  readAllAdmins() {
        List<Admin> adminList = new ArrayList<>();
        try{
            query = "SELECT * FROM users WHERE is_admin = true";
            preparedStatement = this.dataBase.getConnection().prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Admin admin = new Admin();
                admin.setEmail(resultSet.getString("email"));
                admin.setPassword(resultSet.getString("user_password"));
                adminList.add(admin);
            }
            return adminList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeAdmin(String email) {

        query = "UPDATE users SET is_admin = true WHERE email = ?";

        try {
            preparedStatement = this.dataBase.getConnection().prepareStatement(query);
            preparedStatement.setString(1, email);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 0) {
                throw new RuntimeException("Could not find user with the provided email: " + email);
            } else if (rowsAffected == 2) {
                throw new RuntimeException("This user is already an admin.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to write admin to database: " + e.getMessage(), e);
        }
    }

    @Override
    public void editProduct(int productId, String newName, double newPrice, int newQuantity) {
        String query = "UPDATE products SET product_name = ?, product_price = ?, quantity = ? WHERE product_id = ?";
        try {
            PreparedStatement preparedStatement = this.dataBase.getConnection().prepareStatement(query);
            preparedStatement.setString(1, newName);
            preparedStatement.setDouble(2, newPrice);
            preparedStatement.setInt(3, newQuantity);
            preparedStatement.setInt(4, productId);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 0) {
                throw new RuntimeException("Could not find this product.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to edit product in the database: " + e.getMessage(), e);
        }
    }

    @Override
    public void removeAdmin(String email){
        query = "UPDATE users SET is_admin = false WHERE email = ?";

        try {
            preparedStatement = this.dataBase.getConnection().prepareStatement(query);
            preparedStatement.setString(1, email);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 0) {
                throw new RuntimeException("No admin found with email: " + email);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Failed to remove admin from database: " + e.getMessage(), e);
        }

    }

    @Override
    public boolean readAdmin(Admin admin) {
        query = "SELECT is_admin FROM users WHERE email = ? AND user_password = ?";

        try (PreparedStatement preparedStatement = dataBase.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, admin.getEmail());
            preparedStatement.setString(2, admin.getPassword());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getBoolean("is_admin");
                } else {
                    return false;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to read admin data", e);
        }
    }

    @Override
    public void addNewProduct(Product product) throws SQLException, ClassNotFoundException {
        query = "INSERT INTO products (product_name, product_image, product_price, quantity) VALUES (?, ?, ?, ?)";

        try {
            this.preparedStatement = this.dataBase.getConnection().prepareStatement(query);
            this.preparedStatement.setString(1, product.getName());
            this.preparedStatement.setString(2, product.getImage());
            this.preparedStatement.setDouble(3, product.getPrice());
            this.preparedStatement.setInt(4, product.getQuantity());
            this.preparedStatement.executeUpdate();
            this.preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean readProducts(String name) {
        String query = "SELECT * FROM products WHERE product_name = ?";

        try {
            this.preparedStatement = this.dataBase.getConnection().prepareStatement(query);
            this.preparedStatement.setString(1, name);
            this.preparedStatement.execute();
            this.resultSet = this.preparedStatement.getResultSet();
            if (!this.resultSet.next()) {
                this.resultSet.close();
                this.preparedStatement.close();
                return false;
            }
            this.resultSet.close();
            this.preparedStatement.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public void removeProduct(int productId) {
        query = "DELETE FROM products WHERE product_id = ?";

        try {
            preparedStatement = this.dataBase.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, productId);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 0) {
                throw new RuntimeException("No product found with product ID: " + productId);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Failed to remove product from database: " + e.getMessage(), e);
        }
    }
}
