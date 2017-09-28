package com.example.sandipghosh.car2go;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by sandipghosh on 28/09/17.
 */

public class CarList {

    @SerializedName("placemarks")
    @Expose
    private ArrayList<Car> cars = new ArrayList<>();

    /**
     * @return The contacts
     */
    public ArrayList<Car> getCars() {
        return cars;
    }

    /**
     * @param cars The contacts
     */
    public void setContacts(ArrayList<Car> cars) {
        this.cars = cars;
    }
}
