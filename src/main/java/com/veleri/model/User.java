package com.veleri.model;

import java.util.Date;

public class User {
    private int id;
    private String fullName;
    private String email;
    private String password;
    private Date joinDate;

    public User(int id, String fullName, Date createdAt, String email, String password) {
        this.id = id;
        this.fullName = fullName;
        this.joinDate = createdAt;
        this.email = email;
        this.password = password;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getCreatedAt() {
        return joinDate;
    }

    public void setCreatedAt(Date createdAt) {
        this.joinDate = createdAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
