package com.example.demo7.service;

import com.example.demo7.domain.Cart;

import static java.lang.System.out;

public interface CartService {

    Cart addProductsIntoCart(Cart cart) ;

    void orderNow(Cart cartListSession);
}
