package com.example.demo7.service;

import com.example.demo7.domain.Cart;
import com.example.demo7.domain.Product;
import com.example.demo7.resource.cartResource;

import java.io.IOException;
import java.util.List;

import static java.lang.System.out;

public class cartService {

    public Cart addProductsIntoCart(Cart cart) throws IOException {
        cartResource cr = new cartResource();
        out.println(cart.getCartEmail());
        out.println(cart.getTotalPrice());
        out.println(cart.getTotalQuantity());
        cr.writeCart(cart);
        return cart;
    }


}
