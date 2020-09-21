//package com.example.nasapp;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.widget.TextView;
//
//public class CometActivityDescripion extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_comet_descripion);
//        TextView textViewId, textViewName, textViewSizeComet, textViewisPotentiallyHazardousAsteroid, textViewisSentryObject;
//
//        textViewName = findViewById(R.id.textViewId);
//        textViewId = findViewById(R.id.textViewId);
//        textViewSizeComet = findViewById(R.id.textViewSizeComet);
//        textViewisPotentiallyHazardousAsteroid = findViewById(R.id.textViewisPotentiallyHazardousAsteroid);
//        textViewisSentryObject = findViewById(R.id.textViewisSentryObject);
//
//
//
//        Bundle arguments = getIntent().getExtras();
//
//        if (arguments != null) {
//            String name = arguments.getString("name");
//            textViewName.setText(name);
////            int id = arguments.getInt("id");
////            textViewId.setText(id);
////            String sizeComet = arguments.getString("name");
////            textViewSizeComet.setText(sizeComet);
////            Boolean isPotentiallyHazardousAsteroid = arguments.getBoolean("isPotentiallyHazardousAsteroid");
////            Boolean isSentryObject = arguments.getBoolean("isSentryObject");
//
//        }
//    }
//}