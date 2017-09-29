package com.example.sandipghosh.car2go;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by sandipghosh on 29/09/17.
 */

public class DetailsView extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    TextView coordinatestxt, enginetxt, fueltxt, vintxt,nametxt, extraiortxt, interiortxt;

    String address;
    LatLng latLng;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();

        String coordinates = intent.getStringExtra("coordinates");
        String engine = intent.getStringExtra("engine");
        String fuel = intent.getStringExtra("fuel");
        String vin = intent.getStringExtra("vin");
        String name = intent.getStringExtra("name");
        address = intent.getStringExtra("address");
        String extarior = intent.getStringExtra("extarior");
        String interior = intent.getStringExtra("interior");


        enginetxt = (TextView) findViewById(R.id.engine);
        fueltxt = (TextView) findViewById(R.id.fuel);
        vintxt = (TextView) findViewById(R.id.vin);
        nametxt = (TextView) findViewById(R.id.name);
        extraiortxt = (TextView) findViewById(R.id.extarior);
        interiortxt = (TextView) findViewById(R.id.interior);

        String[] latlong =  coordinates.split(",");
        double  longitude = Double.parseDouble(latlong[0].substring(1));
        double  latitude = Double.parseDouble(latlong[1]);

        latLng = new LatLng(latitude, longitude);


        enginetxt.setText("Engine: "+engine);

        fueltxt.setText("Fuel: "+fuel);
        vintxt.setText("Vin: "+vin);
        nametxt.setText("Name: "+name);
        interiortxt.setText("Interior: "+interior);
        extraiortxt.setText("Extarior: "+extarior);



        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.getBaseContext());

        // Showing status
        if (status != ConnectionResult.SUCCESS) { // Google Play Services are not available

            int requestCode = 10;
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, this, requestCode);
            dialog.show();

        } else { // Google Play Services are available

            // Getting reference to the SupportMapFragment of activity_main.xml

            SupportMapFragment fm = (SupportMapFragment) this.getSupportFragmentManager()
                    .findFragmentById(R.id.map);


            fm.getMapAsync(this);

        }

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 11));

        mMap.addMarker(new MarkerOptions()
                .position(latLng)
                .title(address));

    }
}
