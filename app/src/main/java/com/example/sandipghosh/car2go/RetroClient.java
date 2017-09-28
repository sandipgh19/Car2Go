package com.example.sandipghosh.car2go;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sandipghosh on 28/09/17.
 */

public class RetroClient {

    /********
     * URLS
     *******/
    private static final String ROOT_URL = "http://pratikbutani.x10.mx";

    /**
     * Get Retrofit Instance
     */
    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(Config.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * Get API Service
     *
     * @return API Service
     */
    public static CarAPI getApiService() {
        return getRetrofitInstance().create(CarAPI.class);
    }
}
