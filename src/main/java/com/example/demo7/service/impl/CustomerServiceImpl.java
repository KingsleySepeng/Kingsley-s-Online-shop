package com.example.demo7.service.impl;

import com.example.demo7.domain.Customer;
import com.example.demo7.resource.CustomerResource;
import com.example.demo7.resource.impl.CustomerResourceImpl;
import com.example.demo7.service.CustomerService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private List<Customer> customers;

    CustomerResource customerResource = new CustomerResourceImpl();

    public CustomerServiceImpl() {
        this.customers = new ArrayList<>();
    }

    public List<Customer> getCustomers() {
        return this.customers;
    }

    public void setCustomers(Customer customer) throws IOException, SQLException, ClassNotFoundException {
        this.customers.add(customer);
        CustomerResourceImpl crc = null;
        crc = new CustomerResourceImpl();
        crc.createCustomers(customer);
    }


    public boolean customerExist(String email, String password) throws SQLException, ClassNotFoundException {
        return customerResource.readUsers(email, password);
    }

    public void removeCustomer(String email, String password) throws FileNotFoundException, SQLException, ClassNotFoundException {
        CustomerResource crc = new CustomerResourceImpl();
        crc.removeUserRecord(email, password);
    }

    public List<Customer> showAllCustomers() throws SQLException, ClassNotFoundException {
        return customerResource.readAllCustomers();
    }
}


