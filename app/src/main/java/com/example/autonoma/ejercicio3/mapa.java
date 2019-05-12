package com.example.autonoma.ejercicio3;

import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class mapa extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        final LatLng autonoma = new LatLng(-12.195483, -76.9719602);
        LatLng Libreria = new LatLng(-12.1950265, -76.97196449);
        LatLng jugos = new LatLng(-12.1963635, -76.9721322);
        final LatLng makro = new LatLng(-12.192852019393385, -76.97077395815569);
        LatLng parque = new LatLng(-12.191264119284767, -76.96877377767571);
        mMap.addMarker(new MarkerOptions().position(autonoma).title("Universidad Autonoma del peru"));
        mMap.addMarker(new MarkerOptions().position(Libreria).title("Libreria"));
        mMap.addMarker(new MarkerOptions().position(jugos).title("Jugos"));
        mMap.addMarker(new MarkerOptions().position(makro).title("Makro"));
        mMap.addMarker(new MarkerOptions().position(parque).title("Parque Zonal"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(autonoma,15));

    mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
        @Override
        public boolean onMarkerClick(Marker marker) {



            if(marker.getTitle().equalsIgnoreCase("Jugos")){
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.com/maps/search/Jugos/@-12-1947386,-76.9710182,17z"));
    startActivity(intent);
            }
            if(marker.getTitle().equalsIgnoreCase("Libreria")){
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://goo.gl/maps/HXcyKKoTqv"));
                startActivity(intent);
            }

            if(marker.getTitle().equalsIgnoreCase("Makro")){
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://goo.gl/maps/H2p3X4H8ReWcXuVa7"));
                startActivity(intent);
            }
            if(marker.getTitle().equalsIgnoreCase("Parque")){
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.com/maps/place/Parque+Zonal+Huayna+Capac/@-12.1915518,-76.9705498,17z/data=!4m5!3m4!1s0x9105b9a14d662eeb:0x4854d262d24cba2f!8m2!3d-12.1890595!4d-76.9693036"));
                startActivity(intent);
            }


            return false;
        }
    });

    }
}
