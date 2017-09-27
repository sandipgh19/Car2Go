package com.example.sandipghosh.car2go;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by sandipghosh on 27/09/17.
 */

public interface CarAPI {

    public void getCars(Callback<List<Car>> response);
}
