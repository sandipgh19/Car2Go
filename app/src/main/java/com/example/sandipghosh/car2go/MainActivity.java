package com.example.sandipghosh.car2go;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CustomAdapter adapter;
    private Config config;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycle);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        getData();
    }


    private void getData(){
        class GetData extends AsyncTask<Void,Void,String> {
            ProgressDialog progressDialog;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressDialog = ProgressDialog.show(MainActivity.this, "Fetching Data", "Please wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                progressDialog.dismiss();
                parseJSON(s);

            }

            @Override
            protected String doInBackground(Void... params) {
                BufferedReader bufferedReader = null;
                try {
                    URL url = new URL(Config.url);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();

                    bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    String json;
                    while((json = bufferedReader.readLine())!= null){
                        sb.append(json+"\n");
                    }

                    return sb.toString().trim();

                }catch(Exception e){
                    return null;
                }
            }
        }
        GetData gd = new GetData();
        gd.execute();
    }

    public void showData(){
        adapter = new CustomAdapter(this,Config.name,Config.interior, Config.address, Config.engineType, Config.exterior, Config.fuel, Config.vin, Config.coordinates);
        recyclerView.setAdapter(adapter);
    }

    private void parseJSON(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray array = jsonObject.getJSONArray(Config.JSON_ARRAY);

            config = new Config(array.length());

            for(int i=0; i<array.length(); i++){
                JSONObject j = array.getJSONObject(i);
                Config.name[i] = getName(j);
                Config.interior[i] = getinterior(j);
                //JSONArray ja = j.getJSONArray("coordinates");
                Config.coordinates[i] = String.valueOf(j.getJSONArray(Config.coordinates_key));
                Config.address[i] = getAddress(j);
                Config.exterior[i] = getexterior(j);
                Config.vin[i] = getvin(j);
                Config.engineType[i] = getengineType(j);
                Config.fuel[i] = getfuel(j);




            }

        } catch (JSONException e) {
            e.printStackTrace();

        }


        showData();

    }

    private String getName(JSONObject j){
        String name = null;
        try {
            name = j.getString(Config.name_key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return name;
    }

    private String getinterior(JSONObject j){
        String interior = null;
        try {
            interior = j.getString(Config.interirror_key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return interior;
    }

    private String getAddress(JSONObject j){
        String address = null;
        try {
            address = j.getString(Config.address_key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return address;
    }

    private String getengineType(JSONObject j){
        String engineType = null;
        try {
            engineType = j.getString(Config.engineType_key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return engineType;
    }

    private String getexterior(JSONObject j){
        String exterior = null;
        try {
            exterior = j.getString(Config.exterior_key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return exterior;
    }

    private String getfuel(JSONObject j){
        String fuel = null;
        try {
            fuel = j.getString(Config.fuel_key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return fuel;
    }

    private String getvin(JSONObject j){
        String vin = null;
        try {
            vin = j.getString(Config.vin_key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return vin;
    }
}
