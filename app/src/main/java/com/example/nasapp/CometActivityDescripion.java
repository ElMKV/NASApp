package com.example.nasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class CometActivityDescripion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comet_descripion);
        TextView textViewId, textViewName, textViewSizeComet, textViewisPotentiallyHazardousAsteroid, textViewisSentryObject;

        textViewId = findViewById(R.id.textViewId);



        Bundle arguments = getIntent().getExtras();

        if (arguments != null) {
            int id = arguments.getInt("id");

            textViewId.setText(arguments.getString("name"));

            float sizeComet = arguments.getFloat("sizeComet");
            Boolean isPotentiallyHazardousAsteroid = arguments.getBoolean("isPotentiallyHazardousAsteroid");
            Boolean isSentryObject = arguments.getBoolean("isSentryObject");

        }
    }
}