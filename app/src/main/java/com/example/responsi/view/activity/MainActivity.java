package com.example.responsi.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.responsi.R;
import com.example.responsi.view.fragment.HarianFragment;
import com.example.responsi.view.fragment.RsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, BottomNavigationView.OnNavigationItemSelectedListener {

    private Fragment selectedFragment;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.main_navbar);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        loadFragment(new HarianFragment());
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_harian:
                selectedFragment = new HarianFragment();
                loadFragment(selectedFragment);
                break;

            case R.id.menu_rs:
                selectedFragment = new RsFragment();
                loadFragment(selectedFragment);
                break;
        }
        return loadFragment(selectedFragment);
    }

    private boolean loadFragment(Fragment selectedFragment) {
        if (selectedFragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mainframe,selectedFragment)
                    .commit();

            return true;
        }
        return false;
    }
}