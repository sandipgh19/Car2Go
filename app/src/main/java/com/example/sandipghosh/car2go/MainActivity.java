package com.example.sandipghosh.car2go;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Car> cars;
    //private ArrayList<Contact> contactList;
    private CustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycle);
        cars = new ArrayList<>();

        //Creating an object of our api interface
        CarAPI api = RetroClient.getApiService();

        /**
         * Calling JSON
         */
        Call<CarList> call = api.getCars();

        /**
         * Enqueue Callback will be call when get response...
         */
        call.enqueue(new Callback<CarList>() {
            @Override
            public void onResponse(Call<CarList> call, Response<CarList> response) {

                if(response.isSuccessful()) {
                    /**
                     * Got Successfully
                     */
                    cars = response.body().getCars();

                    /**
                     * Binding that List to Adapter
                     */
                    //CustomAdapter customAdapter = new CustomAdapter(MainActivity.this, cars);
                    adapter = new CustomAdapter(cars);
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(mLayoutManager);
                    recyclerView.setAdapter(adapter);
                    //recyclerView.setAdapter(customAdapter);

                }
            }

            @Override
            public void onFailure(Call<CarList> call, Throwable t) {
                //dialog.dismiss();
            }
        });


        //getCars();
    }

    private void getCars() {


      /*  Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://redirect.mytaxi.net")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CarAPI service = retrofit.create(CarAPI.class);
        Call<List<Car>> call=   service.getCars();
        call.enqueue(new Callback<List<Car>>() {
            @Override
            public void onResponse(Call<List<Car>> call, Response<List<Car>> response) {

                Log.i("response123", String.valueOf(response));

                List<Car> list = response.body();
                Car product = null;
                for (int i =0 ;i<list.size();i++){
                    product = new Car();
                    String name = list.get(i).getName();
                    String iinterior = list.get(i).getInterior();
                    product.setName(name);
                    product.setInterior(iinterior);

                    cars.add(product);
                }

                CustomAdapter customAdapter = new CustomAdapter(cars);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setAdapter(customAdapter);


            }

            @Override
            public void onFailure(Call<List<Car>> call, Throwable t) {

            }
        });*/

    }
}
