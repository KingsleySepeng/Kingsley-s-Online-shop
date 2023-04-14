package com.example.demo7.resource.impl;

import com.example.demo7.database_dao.DataBaseManager;
import com.example.demo7.domain.Customer;
import com.example.demo7.resource.CustomerResource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerResourceImpl implements CustomerResource {
    private DataBaseManager dataBase;
    private String query;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public CustomerResourceImpl() {
        try {
            this.dataBase = new DataBaseManager();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createCustomers(Customer customer) throws SQLException, ClassNotFoundException {
        query = "INSERT INTO users (first_name, surname, email, user_password, date_of_birth, is_admin) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            this.preparedStatement = this.dataBase.getConnection().prepareStatement(query);
            this.preparedStatement.setString(1, customer.getName());
            this.preparedStatement.setString(2, customer.getSurname());
            this.preparedStatement.setString(3, customer.getEmail());
            this.preparedStatement.setString(4, customer.getPassword());
            this.preparedStatement.setString(5, customer.getDob());
            this.preparedStatement.setBoolean(6, customer.isAdmin());
            this.preparedStatement.executeUpdate();
            this.preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean readUsers(String email, String password) throws SQLException, ClassNotFoundException {
        query = "SELECT * FROM users WHERE email = ? AND user_password = ?";

        try {
            this.preparedStatement = this.dataBase.getConnection().prepareStatement(query);
            this.preparedStatement.setString(1, email);
            this.preparedStatement.setString(2, password);
            this.preparedStatement.execute();
            this.resultSet = this.preparedStatement.getResultSet();
            if (!this.resultSet.next()) {
                this.resultSet.close();
                this.preparedStatement.close();
                return false;
            }
            this.resultSet.close();
            this.preparedStatement.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public void removeUserRecord(String email, String password) throws SQLException, ClassNotFoundException {
        query = "DELETE FROM users WHERE email =? AND user_password =?";

        try {
            this.preparedStatement = dataBase.getConnection().prepareStatement(query);
            this.preparedStatement.setString(1, email);
            this.preparedStatement.setString(2, password);
            this.preparedStatement.execute();
        } catch (SQLException e) {
        }
    }

    public List<Customer> readAllCustomers() {
        List<Customer> customerList = new ArrayList<>();
        try {
            query = "SELECT * FROM users WHERE is_admin = false";
            preparedStatement = this.dataBase.getConnection().prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setEmail(resultSet.getString("email"));
                customer.setPassword(resultSet.getString("user_password"));
                customerList.add(customer);
            }
            return customerList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
