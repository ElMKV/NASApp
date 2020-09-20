package com.example.nasapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView textViewName;
    TextView textViewDesc;
    ImageView imageView;
    RecyclerView recyclerView;


    private String KEY = "1gzGfmSJbbcPKLiDyd59NHKlQhXSD8iAbGnezrDS";
    private String stratDate = "2015-09-07";
    private String endDate = "2015-09-08";

    CometAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewName = (TextView) findViewById(R.id.textViewTitle);
        textViewDesc = (TextView) findViewById(R.id.textViewDesc);
        imageView = (ImageView) findViewById(R.id.imageView);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);



        loadJSON();
    }


    private void loadJSON() {

        NetworkService.getInstance()
                .getHolder()
                .getPostWithID(KEY)
                .enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(@NonNull Call<Post> call, @NonNull Response<Post> response) {
                        Post post = response.body();
                        textViewName.append(post.getTitle());
                        textViewDesc.append(post.getExplanation());
                        Picasso.with(getApplicationContext())
                                .load(post.getUrl())
                                .placeholder(R.drawable.ic_launcher_background)
                                .error(R.drawable.dino_error)
                                .into(imageView);
                    }

                    @Override
                    public void onFailure(@NonNull Call<Post> call, @NonNull Throwable t) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Error occurred while getting request!", Toast.LENGTH_SHORT);
                        t.printStackTrace();
                    }
                });
        NetworkService.getInstance()
                .getHolder()
                .getJSON(KEY)
                .enqueue(new Callback<Comet>() {
                    @Override
                    public void onResponse(Call<Comet> call, Response<Comet> response) {

                        Log.d("log", "вошел");
                        Comet comets = response.body();

                        ArrayList<NearEarthObject>nearEarthObjects = (ArrayList<NearEarthObject>) comets.getNearEarthObjects();
                        adapter = new CometAdapter(MainActivity.this,nearEarthObjects);

                        recyclerView.setAdapter(adapter);

                        Log.d("log", String.valueOf(nearEarthObjects.size()));

                        for (int i = 0; i<nearEarthObjects.size(); i++)
                        {
                            Log.d("log", nearEarthObjects.get(i).getName());

                        }



                    }

                    @Override
                    public void onFailure(Call<Comet> call, Throwable t) {
                        Log.d("log", "не вошел" + t);


                    }
                });
    }

}
