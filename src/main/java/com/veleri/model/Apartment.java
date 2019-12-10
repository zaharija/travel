package com.veleri.model;

public class Apartment {
    private int id;
    private double price;
    private int beds;
    private int stars;
    private Place place;

    public Apartment(int id, double price, int beds, int stars, Place place) {
        this.id = id;
        this.price = price;
        this.beds = beds;
        this.stars = stars;
        this.place = place;
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

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
