package com.example.demo7.domain;

public class Admin {
    private String email;
    private String password;

    public Admin() {
    }

    public Admin(String email, String login) {
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail()
    {
       return this.email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }

}
