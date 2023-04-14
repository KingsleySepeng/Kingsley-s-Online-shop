package com.example.demo7.resource;

import com.example.demo7.domain.Cart;
import com.example.demo7.domain.Product;

import java.sql.SQLException;

public interface CartResource {

    void writeCart(Cart cart) ;

    void editProductsQuantity(Cart cartListSession) ;
}
