package com.example.nasapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

    TextView textViewNameComet;
    private String KEY = "1gzGfmSJbbcPKLiDyd59NHKlQhXSD8iAbGnezrDS";
    private String stratDate = "2015-09-07";
    private String endDate = "2015-09-08";

    private ArrayList<NearNarthObjects> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textViewName = (TextView) findViewById(R.id.textViewTitle);
        textViewDesc = (TextView) findViewById(R.id.textViewDesc);
        imageView = (ImageView) findViewById(R.id.imageView);

        loadJSON();

        textViewNameComet = (TextView) findViewById(R.id.textViewNameComet);

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
    }


        private void loadJSON () {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.nasa.gov")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            NASAIMAGEAPI request = retrofit.create(NASAIMAGEAPI.class);
            Call<JSONResponse> call = request.getJSON(KEY);
            call.enqueue(new Callback<JSONResponse>() {
                @Override
                public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                    System.out.println("вошел");

                    JSONResponse jsonResponse = response.body();
                    data = new ArrayList<>(Arrays.asList(jsonResponse.getNearNarthObjects()));



                }

                @Override
                public void onFailure(Call<JSONResponse> call, Throwable t) {

                }
            });


        }

}
