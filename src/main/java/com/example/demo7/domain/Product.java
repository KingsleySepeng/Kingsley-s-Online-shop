package com.example.demo7.domain;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.out;

public class Product {

    private int id;
    private String name;
    private String image;
    private double price;
    private int quantity;

    private boolean onSpecial;

    public Product(int id, String name, String image, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
    }
    public Product(){}

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getImage() {return image;}
    public void setImage(String image) {this.image = image;}

    public double getPrice(){return price;}
    public void setPrice(double price){this.price = price;}

    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) {this.quantity = quantity;}

    public void incrementProductQuantity(){
        this.quantity ++;
    }

    public void decrementProductQuantity(){
        this.quantity --;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\''+
                ", image='" + image + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }


}
