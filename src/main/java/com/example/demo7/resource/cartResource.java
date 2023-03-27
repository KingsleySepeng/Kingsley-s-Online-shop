package com.example.demo7.resource;

import com.example.demo7.domain.Cart;
import com.example.demo7.domain.Customer;
import com.example.demo7.domain.Product;
import com.example.demo7.service.cartService;
import com.example.demo7.service.createFile;
import com.example.demo7.service.customerService;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class cartResource {
    public void writeCart(Cart cart) throws IOException {
        String filePath = "/home/kingsley/Downloads/demo7/src/main/java/com/example/demo7/tblCart.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        String email = cart.getCartEmail();
        boolean emailFound = false;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("===") && line.contains((email))) {
                emailFound = true;
                //change price, total quantity, total price
                break;
            }
        }
        reader.close();

        if (!emailFound) {
            writer.write("===" + email + ":" + "==CART SUMMARY:==");
            writer.newLine();

            for (Product product : cart.getCartList()) {
                writer.write("Product ID: " + product.getId() + ",");
                writer.newLine();
                writer.write("Product Name: " + product.getName() + ",");
                writer.newLine();
                writer.write("Price: " + product.getPrice() + ",");
                writer.newLine();
            }
            writer.newLine();
            writer.write("Quantity: " + cart.getTotalQuantity());
            writer.newLine();
            writer.write("Total Price: " + cart.getTotalPrice());
            writer.newLine();
            writer.write("============");
            writer.close();
        }
    }

}
