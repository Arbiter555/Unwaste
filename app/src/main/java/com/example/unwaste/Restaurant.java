package com.example.unwaste;

import com.google.gson.annotations.SerializedName;

public class Restaurant {

    @SerializedName("location")
    private final String location;

    @SerializedName("open_hours")
    private final String open_hours;

    @SerializedName("available_for_pickup")
    private final String available_for_pickup;

    @SerializedName("cuisine_type")
    private final String cuisine_type;

    public Restaurant(String location, String open_hours, String available_for_pickup, String cuisine_type) {
        this.location = location;
        this.open_hours = open_hours;
        this.available_for_pickup = available_for_pickup;
        this.cuisine_type = cuisine_type;
    }

    public String getLocation() {
        return location;
    }

    public String getOpen_hours() {
        return open_hours;
    }

    public String getAvailable_for_pickup() {
        return available_for_pickup;
    }

    public String getCuisine_type() {
        return cuisine_type;
    }
}
