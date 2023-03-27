package com.example.demo7.service;

import java.io.File;
import java.io.IOException;

public class createFile {
    public static void tblCart() {
        try {
            //create tblUserCart +"email + cart.txt"
            File newTxt = new File("/home/kingsley/Downloads/demo7/src/main/java/com/example/demo7/tblCart.txt");
            if (newTxt.createNewFile()) {
                System.out.println("File created: " + newTxt.getName());

            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("error has occurred");
            e.printStackTrace(); //method used to handle exceptions and errors...will show where the error is in code
        }
    }
}

