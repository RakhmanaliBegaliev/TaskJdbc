package com.peaksoft;

public class Country {
    private int id;
    private String name;
    private String city_of_country;

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

    public String getCity_of_country() {
        return city_of_country;
    }

    public void setCity_of_country(String city_of_country) {
        this.city_of_country = city_of_country;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city_of_country='" + city_of_country + '\'' +
                '}';
    }
}
