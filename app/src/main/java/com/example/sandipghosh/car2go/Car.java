package com.example.sandipghosh.car2go;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sandipghosh on 27/09/17.
 */

public class Car {

    private String address;
    private String coordinates;
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("interior")
    @Expose
    private String interior;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInterior() {
        return interior;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }
}
