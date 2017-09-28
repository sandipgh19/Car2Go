package com.example.sandipghosh.car2go;

import java.util.List;


import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sandipghosh on 27/09/17.
 */

public interface CarAPI {

    @GET("/car2go/vehicles.json")
    Call<CarList> getCars();


}
