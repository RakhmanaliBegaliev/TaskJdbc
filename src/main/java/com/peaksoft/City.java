package com.peaksoft;

public class City {
private int id;
private String name;
private String presidet_of_city;

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

    public String getPresidet_of_city() {
        return presidet_of_city;
    }

    public void setPresidet_of_city(String presidet_of_city) {
        this.presidet_of_city = presidet_of_city;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", presidet_of_city='" + presidet_of_city + '\'' +
                '}';
    }
}
