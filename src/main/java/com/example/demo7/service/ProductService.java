package com.example.demo7.service;

import com.example.demo7.database_dao.DataBaseManager;
import com.example.demo7.domain.Product;
import com.example.demo7.resource.impl.ProductResourceImpl;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    List<Product> showProducts() throws SQLException, ClassNotFoundException ;
}
