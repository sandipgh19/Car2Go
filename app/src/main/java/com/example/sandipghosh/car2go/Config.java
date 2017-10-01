package com.example.sandipghosh.car2go;


/**
 * Created by sandipghosh on 27/09/17.
 */

public class Config {

    public static String[] name;
    public static String[] interior;
    public static String[] coordinates;
    public static String[] address;
    public static String[] engineType;
    public static String[] exterior;
    public static String[] fuel;
    public static String[] vin;

    public static final String url="http://redirect.mytaxi.net/car2go/vehicles.json";
    public static final String name_key="name";
    public static final String coordinates_key="coordinates";
    public static final String interirror_key="interior";
    public static final String address_key="address";
    public static final String engineType_key="engineType";
    public static final String exterior_key="exterior";
    public static final String fuel_key="fuel";
    public static final String vin_key="vin";
    public static final String JSON_ARRAY = "placemarks";


    public Config(int i){
        name = new String[i];
        interior = new String[i];
        coordinates = new String[i];
        address = new String[i];
        engineType = new String[i];
        exterior = new String[i];
        fuel = new String[i];
        vin = new String[i];
    }
}

