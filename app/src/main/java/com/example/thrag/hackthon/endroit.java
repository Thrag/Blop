package com.example.thrag.hackthon;

/**
 * Created by Thrag on 25/03/15.
 */
public class Endroit {

    private int id;
    private String name;
    private String description;
    private float latitude;
    private float longitude;
    private String city;
    private String category;
    private String address;
    private String phone;

    //Constructor
    public Endroit(String description, String name, float latitude, float longitude, String city, String category, String address, String phone) {
        this.description = description;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
        this.category = category;
        this.address = address;
        this.phone = phone;
    }

    public Endroit(){}

    //Getters
    public float getLatitude() {
        return latitude;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getLongitude() {
        return longitude;
    }

    public String getCity() {
        return city;
    }

    public String getCategory() {
        return category;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public int getID() { return id; }


    //Setters
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID (int id) { this.id = id; }

}
