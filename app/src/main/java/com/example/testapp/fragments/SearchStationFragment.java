package com.example.testapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.testapp.App;
import com.example.testapp.R;

public class SearchStationFragment extends Fragment implements AdapterView.OnItemSelectedListener{

private ArrayAdapter arrayAdapter;

    private Spinner spinnerSearchBy;
    private long searchBy = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_station, container, false);
        arrayAdapter = ArrayAdapter.createFromResource(App.getAppContext(), R.array.search_by, android.R.layout.simple_spinner_item );
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSearchBy = view.findViewById(R.id.spinnerSearch);
        spinnerSearchBy.setAdapter(arrayAdapter);
        spinnerSearchBy.setOnItemSelectedListener(this);
        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.i("id", Long.toString(id));
        if (id == 3){
            MapsFragment mapFragment = new MapsFragment();
            mapFragment.addMarker(51.1076946, 17.0408588, "test", true);
            mapFragment.addMarker(51.111898687185175, 17.060284213050814, "test2", true);
            getFragmentManager().beginTransaction().replace(R.id.container, mapFragment).commit();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}