package com.example.demo7.service;

import com.example.demo7.domain.Customer;
import com.example.demo7.resource.impl.CustomerResourceImpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface CustomerService {

    void setCustomers(Customer customer) throws IOException, SQLException, ClassNotFoundException ;

    boolean customerExist(String email, String password) throws SQLException, ClassNotFoundException ;

    void removeCustomer(String email, String password) throws FileNotFoundException, SQLException, ClassNotFoundException ;

    List<Customer> showAllCustomers() throws SQLException, ClassNotFoundException ;
}

