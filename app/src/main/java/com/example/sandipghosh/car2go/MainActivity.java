package com.example.sandipghosh.car2go;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Car> cars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycle);

        getCars();
    }

    private void getCars() {

        //While the app fetched data we are displaying a progress dialog
        final ProgressDialog loading = ProgressDialog.show(this,"Fetching Data","Please wait...",false,false);

        //Creating a rest adapter
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(Config.url)
                .build();

        //Creating an object of our api interface
        CarAPI api = adapter.create(CarAPI.class);

        //Defining the method
        api.getCars(new Callback<List<Car>>() {
            @Override
            public void success(List<Car> list, Response response) {
                //Dismissing the loading progressbar
                loading.dismiss();

                //Storing the data in our list
                cars = list;

                //Calling a method to show the list
                //showList();
            }

            @Override
            public void failure(RetrofitError error) {
                //you can handle the errors here
            }
        });
    }
}
