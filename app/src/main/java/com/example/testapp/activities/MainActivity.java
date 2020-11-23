package com.example.testapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.testapp.App;
import com.example.testapp.R;
import com.example.testapp.fragments.CreateStationFragment;
import com.example.testapp.fragments.MapsFragment;
import com.example.testapp.fragments.SearchStationFragment;
import com.example.testapp.fragments.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    //CompositeDisposable disposable = new CompositeDisposable();
    App app;
    private BottomNavigationView bottomNavigationView;
    private MapsFragment mapsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        app = (App) getApplication();
        bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavMethod);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new MapsFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavMethod = new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment fragment = null;
                    switch (menuItem.getItemId()) {
                        case R.id.map:
                            fragment = new MapsFragment();
                            break;
                        case R.id.search:
                            fragment = new SearchStationFragment();
                            break;
                        case R.id.create:
                            fragment = new CreateStationFragment();
                            break;
                        case R.id.settings:
                            fragment = new SettingsFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
                    return false;
                }
            };


}