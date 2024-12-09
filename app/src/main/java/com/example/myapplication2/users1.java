package com.example.myapplication2;

public class users1 {
    private String username;
    private  String  email;
    public users1(){

    }
    public users1(String username, String email)
    {
        this.username=username;
        this.email= email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
