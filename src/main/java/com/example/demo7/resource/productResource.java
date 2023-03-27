package com.example.demo7.resource;

import com.example.demo7.domain.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class productResource {
    public List<Product> readProductFromFile() throws IOException {
        List<Product> products = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("/home/kingsley/Downloads/demo7/src/main/java/com/example/demo7/tblProduct.txt"));
        String line;
// look at generics
        while ((line = reader.readLine()) != null) {
            {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String photoPath = parts[1];
                String productName = parts[2];
                double price = Double.parseDouble(parts[3]);
                int quantity = Integer.parseInt(parts[4]);
                Product product = new Product(id, photoPath, productName, price, quantity);
                products.add(product);
            }
        }
        reader.close();
        return products;
    }

}
