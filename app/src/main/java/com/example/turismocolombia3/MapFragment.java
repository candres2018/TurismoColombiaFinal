package com.example.turismocolombia3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends Fragment implements OnMapReadyCallback {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        googleMap.clear(); //clear old markers

        // Map on Pasto
        CameraPosition googlePlex = CameraPosition.builder()
                .target(new LatLng(1.214631, -77.278286))   // Pasto Location
                .zoom(14)
                .bearing(0)
                .tilt(45)
                .build();

        // Camara Transition
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex), 3000, null);

        // Marker on Pasto
        googleMap.addMarker(new MarkerOptions()
            .position(new LatLng(1.214631, -77.278286))
            .title("Esto es Pasto XD")
            .snippet("Aquí"));
    }
}
