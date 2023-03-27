package com.example.demo7.service;

import com.example.demo7.controller.customerServlet;
import com.example.demo7.domain.Customer;
import com.example.demo7.resource.cartResource;
import com.example.demo7.resource.customerResource;
import com.example.demo7.resource.resource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.sun.org.apache.xpath.internal.compiler.Token.contains;

public class customerService {
    private List<Customer> customers;

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customer) throws IOException {
        customers.add(customer);
        customerResource crc = new customerResource();
        crc.createCustomers(getCustomers());

    }

    public boolean loginValid(String email, String password) {
        customerResource crc = new customerResource();
        return crc.readUsers(email, password);
    }

    public boolean customerExist(String email, String password) {
        customerResource crc = new customerResource();
        return crc.readUsers(email, password);
    }

    public void removeCustomer(String email, String password) throws FileNotFoundException {
        customerResource crc = new customerResource();
        crc.removeUserRecord(email, password);
    }
}


