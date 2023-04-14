package com.example.demo7.resource;

import com.example.demo7.domain.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CustomerResource {

    void createCustomers(Customer customer) throws SQLException, ClassNotFoundException ;

    boolean readUsers(String email, String password) throws SQLException, ClassNotFoundException ;

    void removeUserRecord(String email, String password) throws SQLException, ClassNotFoundException ;

    List<Customer> readAllCustomers() ;

}
