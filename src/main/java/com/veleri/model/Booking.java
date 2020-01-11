package com.veleri.model;

import java.util.Date;

public class Booking {
    private int id;
    private Date bookingStart;
    private Date bookingEnd;
    private User user;
    private Apartment apartment;

    public Booking(int id, Date bookingStart, Date bookingEnd, User user, Apartment apartment) {
        this.id = id;
        this.bookingStart = bookingStart;
        this.bookingEnd = bookingEnd;
        this.user = user;
        this.apartment = apartment;
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
