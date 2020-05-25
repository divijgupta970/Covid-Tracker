package com.example.covidtracker.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.covidtracker.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatisticsFragment statisticsFragment = new StatisticsFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, statisticsFragment, null).commit();
    }
}