package com.example.demo7.resource;

import com.example.demo7.domain.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ProductResource {

    List<Product> getAllProducts();
}
