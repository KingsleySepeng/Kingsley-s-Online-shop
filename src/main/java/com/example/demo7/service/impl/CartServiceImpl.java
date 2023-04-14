package com.example.demo7.service.impl;

import com.example.demo7.domain.Cart;
import com.example.demo7.resource.CartResource;
import com.example.demo7.resource.impl.CartResourceImpl;
import com.example.demo7.service.CartService;

import static java.lang.System.out;

public class CartServiceImpl implements CartService {
    CartResource cartResource = new CartResourceImpl();

    @Override
    public Cart addProductsIntoCart(Cart cart) {
        out.println(cart.getCartEmail());
        out.println(cart.getTotalPrice());
        out.println(cart.getTotalQuantity());
        cartResource.writeCart(cart);
        return cart;
    }

    @Override
    public void orderNow(Cart cartListSession) {
        cartResource.editProductsQuantity(cartListSession);
    }


}
