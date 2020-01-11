package com.veleri.model;

public class Apartment {
    private int id;
    private String name;
    private String price;
    private String beds;
    private String stars;
    private Place place;
    private Owner owner;

    public Apartment(int id, String price, String name, String beds, String stars, Place place, Owner owner) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.beds = beds;
        this.stars = stars;
        this.place = place;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
