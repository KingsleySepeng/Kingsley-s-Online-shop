package com.example.demo7.domain;

import java.util.ArrayList;
import java.util.List;


public class Cart {

    private List<Product> cartList = new ArrayList<Product>();
    private String cartEmail;
    private int totalQuantity;
    private double totalPrice;

    public List<Product> getCartList() {
        return cartList;
    }

    public void addProductToCart(Product product) {
        this.cartList.add(product);
        this.totalQuantity += product.getQuantity();
        this.totalPrice += product.getPrice() * product.getQuantity();
    }

    public String getCartEmail() {
        return cartEmail;
    }

    public void setCartEmail(String cartEmail) {
        this.cartEmail = cartEmail;
    }


    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }


    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartEmail='" + cartEmail + '\'' +
                ", cartList=" + cartList +
                ", totalQuantity=" + totalQuantity +
                ", totalPrice=" + totalPrice +
                '}';
    }

    //goes to cartService
    public void removeFromCart(int productId) {
        for(Product product : cartList) {
            if(product.getId() == productId) {
                cartList.remove(product);
                break;
            }
        }

    }
}


