package com.veleri.model;

public class Apartment {
    private int id;
    private String price;
    private String beds;
    private String stars;
    private Place place;

    public Apartment(int id, String price, String beds, String stars, Place place) {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBeds() {
        return beds;
    }

    public void setBeds(String beds) {
        this.beds = beds;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
