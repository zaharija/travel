package com.veleri.model;

public class Place {
    private int id;
    private String name;
    private String county;

    public Place(int id, String name, String county) {
        this.id = id;
        this.name = name;
        this.county = county;
    }

    public Place() {

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

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }
}
