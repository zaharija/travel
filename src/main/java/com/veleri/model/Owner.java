package com.veleri.model;

import java.util.Date;

public class Owner {
    private int id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private Date joinDate;

    public Owner(int id, String fullName, String email, String phoneNumber, Date createdAt) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.joinDate = createdAt;
    }

    public Owner() {

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
