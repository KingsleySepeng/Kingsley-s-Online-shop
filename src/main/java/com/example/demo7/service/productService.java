package com.example.demo7.service;

import com.example.demo7.domain.Product;
import com.example.demo7.resource.productResource;

import java.io.IOException;
import java.util.List;

public class productService {
    public List<Product> showProducts() throws IOException {
        productResource pdr = new productResource();
        return pdr.readProductFromFile();
    }
}
