package com.example.demo7.resource.impl;

import com.example.demo7.database_dao.DataBaseManager;
import com.example.demo7.domain.Cart;
import com.example.demo7.domain.Product;
import com.example.demo7.resource.CartResource;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CartResourceImpl implements CartResource {
    private DataBaseManager dataBase;
    private String query;
    private PreparedStatement preparedStatement;

    public CartResourceImpl() {
        try {
            this.dataBase = new DataBaseManager();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeCart(Cart cart) {
        this.query = "INSERT INTO cart (product_id, product_name, product_price, total_quantity, total_price) VALUES (?, ?, ?, ?, ?)";

        try {
            this.preparedStatement = this.dataBase.getConnection().prepareStatement(query);
            for (Product product : cart.getCartList()) {
                this.preparedStatement.setInt(1, product.getId());
                this.preparedStatement.setString(2, product.getName());
                this.preparedStatement.setDouble(3, product.getPrice());
                this.preparedStatement.setDouble(4, cart.getTotalQuantity());
                this.preparedStatement.setDouble(5, cart.getTotalPrice());
                this.preparedStatement.executeUpdate();
            }
            this.preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void editProductsQuantity(Cart cartListSession) {
        this.query = "UPDATE products SET quantity = quantity - ? WHERE product_id = ?";
        try {
            this.preparedStatement = this.dataBase.getConnection().prepareStatement(query);
            for (Product cartProduct : cartListSession.getCartList()) {
                int productId = cartProduct.getId();
                int quantityInCart = cartProduct.getQuantity();
                this.preparedStatement.setInt(1, quantityInCart);
                this.preparedStatement.setInt(2, productId);
                this.preparedStatement.executeUpdate();
            }
            this.preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
