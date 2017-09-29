package com.example.sandipghosh.car2go;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by sandipghosh on 29/09/17.
 */

public class DetailsView extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

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


        double latit = 28.365398;//Double.parseDouble(profileSharedPreferences.getString("lat",""));
        double longit = 75.586105;//Double.parseDouble(profileSharedPreferences.getString("lng",""));

        LatLng latLng = new LatLng(latit, longit);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 11));

    }
}
