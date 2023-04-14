package com.example.demo7.domain;

import java.util.List;

public class Customer {
    //fields
    //fix the structure, change to private
    private int userId;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String dob;
    private boolean isAdmin;

    public Customer(int userId, String name, String surname, String email, String password, String dob, boolean isAdmin) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.isAdmin = isAdmin;
    }

    public Customer() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }
    public String setName(String name){this.name = name; return name;}

    public String getSurname() {
        return surname;
    }
    public String setSurname(String surname){this.surname = surname; return surname;}


    public String getEmail() {
        return email;
    }
    public String setEmail(String email){this.email = email;return email;}

    public String getPassword() {
        return password;
    }
    public String setPassword(String password){this.password = password;return password;}

    public String getDob() {
        return dob;
    }
    public String setDob(String dob){this.dob = dob;return dob;}

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
