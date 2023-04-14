package com.example.demo7.resource.impl;

import com.example.demo7.database_dao.DataBaseManager;
import com.example.demo7.domain.Product;
import com.example.demo7.resource.ProductResource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductResourceImpl implements ProductResource {
    private DataBaseManager dataBase;
    private String query;
    private PreparedStatement preparedStatement;

    private ResultSet resultSet;

    public ProductResourceImpl(DataBaseManager dataBase) {
        super();
        this.dataBase = dataBase;
    }

    @Override
    public List<Product> getAllProducts(){
        List<Product> products = new ArrayList<>();
        try {
            query = "SELECT * FROM products";
            preparedStatement = this.dataBase.getConnection().prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("product_id"));
                product.setName(resultSet.getString("product_name"));
                product.setImage(resultSet.getString("product_image"));
                product.setPrice(resultSet.getDouble("product_price"));
                product.setQuantity(resultSet.getInt("quantity"));

                products.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

}

