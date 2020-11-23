package com.example.testapp.fragments;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.example.testapp.App;
import com.example.testapp.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsCreateStationFragment extends Fragment implements OnMapReadyCallback {

    GoogleMap googleMap;
    private ArrayList<MarkerOptions> markers;

    public MapsCreateStationFragment() {
        this.markers = new ArrayList<MarkerOptions>();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapView);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this::onMapReady);
        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        if (ActivityCompat.checkSelfPermission(App.getAppContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

        }
        if (markers.size() != 0) {
            for (MarkerOptions marker : this.markers) {
                googleMap.addMarker(marker);
            }
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(markers.get(0).getPosition()));
        }else{
            LatLng tmp = new LatLng(51.10613247628298, 17.086756893213984);
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(tmp));
        }
        this.googleMap = googleMap;
    }

    public void addMarker(double x, double y, String title, boolean draggable) {
        this.markers.add(new MarkerOptions()
                .position(new LatLng(x, y))
                .draggable(draggable)
                .title(title));
    }
}