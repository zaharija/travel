package com.veleri.rwa.oot.Entity;

public class Apartment {
    private int id;
    private double price;
    private int beds;
    private int stars;

    public Apartment(int id, double price, int beds, int stars) {
        this.id = id;
        this.price = price;
        this.beds = beds;
        this.stars = stars;
    }

    public Apartment() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
