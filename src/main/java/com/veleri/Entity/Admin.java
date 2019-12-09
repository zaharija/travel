package com.veleri.Entity;

import java.util.Date;

public class Admin {
    private int id;
    private String fullName;
    private Date createdAt;
    private String email;
    private String password;

    public Admin(int id, String fullName, Date createdAt, String email, String password) {
        this.id = id;
        this.fullName = fullName;
        this.createdAt = createdAt;
        this.email = email;
        this.password = password;
    }

    public Admin() {

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
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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
