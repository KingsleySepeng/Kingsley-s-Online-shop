package com.example.demo7.database_dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseManager {
    private String dbUrl = "jdbc:mysql://localhost:3306/flower_shop";

    private String user = "root";

    private String password = "2023";

    private Connection connection;

    public  DataBaseManager() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        DriverManager.setLogWriter(new PrintWriter(System.out));
        this.connection = DriverManager.getConnection(this.dbUrl, this.user, this.password);
    }
    public Connection getConnection() throws SQLException {
        return this.connection;
    }

    public String getDbUrl() {
        return dbUrl;
    }
}
