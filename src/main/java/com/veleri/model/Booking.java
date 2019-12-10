package com.veleri.model;

import java.util.Date;

public class Booking {
    private int id;
    private User user;
    private Apartment apartment;
    private Date bookingStart;
    private Date bookingEnd;
    private Date joinDate;

    public Booking(int id, User user, Date createdAt, Apartment apartment, Date bookingStart, Date bookingEnd) {
        this.id = id;
        this.user = user;
        this.joinDate = createdAt;
        this.apartment = apartment;
        this.bookingStart = bookingStart;
    }

    public Booking() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreatedAt() {
        return joinDate;
    }

    public void setCreatedAt(Date createdAt) {
        this.joinDate = createdAt;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public Date getBookingStart() {
        return bookingStart;
    }

    public void setBookingStart(Date bookingStart) {
        this.bookingStart = bookingStart;
    }

    public Date getBookingEnd() {
        return bookingEnd;
    }

    public void setBookingEnd(Date bookingEnd) {
        this.bookingEnd = bookingEnd;
    }
}
