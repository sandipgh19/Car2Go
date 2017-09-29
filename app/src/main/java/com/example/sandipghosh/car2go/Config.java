package com.example.sandipghosh.car2go;

import java.lang.reflect.Array;

/**
 * Created by sandipghosh on 27/09/17.
 */

public class Config {

    public static String[] name;
    public static String[] interior;
    public static String[] coordinates;
    public static String[] address;

    public static final String url="http://redirect.mytaxi.net/car2go/vehicles.json";
    public static final String name_key="name";
    public static final String coordinates_key="coordinates";
    public static final String interirror_key="interior";
    public static final String address_key="address";
    public static final String JSON_ARRAY = "placemarks";


    public Config(int i){
        name = new String[i];
        interior = new String[i];
        coordinates = new String[i];
        address = new String[i];
    }
}

