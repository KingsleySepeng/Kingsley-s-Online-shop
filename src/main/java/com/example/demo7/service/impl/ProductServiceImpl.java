package com.example.demo7.service.impl;

import com.example.demo7.database_dao.DataBaseManager;
import com.example.demo7.domain.Product;
import com.example.demo7.resource.ProductResource;
import com.example.demo7.resource.impl.ProductResourceImpl;
import com.example.demo7.service.ProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> showProducts() throws SQLException, ClassNotFoundException {
        ProductResource productResource = new ProductResourceImpl(new DataBaseManager());
        return productResource.getAllProducts();
    }

}
