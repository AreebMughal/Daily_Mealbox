package com.example.dailymeal_Classes;

public class User {
    private String name;
    private String uname;
    private String password;


    public User(String name, String uname, String password) {
        this.name = name;
        this.uname = uname;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
