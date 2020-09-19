package com.example.nasapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Query;

public class MainActivity extends AppCompatActivity {

    TextView textViewName;
    TextView textViewDesc;
    ImageView imageView;

    TextView textViewNameComet;
    private String KEY = "1gzGfmSJbbcPKLiDyd59NHKlQhXSD8iAbGnezrDS";
    private String stratDate = "2015-09-07";
    private String endDate = "2015-09-08";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textViewName = (TextView) findViewById(R.id.textViewTitle);
        textViewDesc = (TextView) findViewById(R.id.textViewDesc);
        imageView = (ImageView) findViewById(R.id.imageView);

        textViewNameComet = (TextView) findViewById(R.id.textViewNameComet);

        NetworkService.getInstance()
                .getImage()
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
                .getData()
                .getData(KEY)
                .enqueue(new Callback<Comet>() {
                    @Override
                    public void onResponse(Call<Comet> call, Response<Comet> response) {
                        Comet comet = response.body();
//                        textViewNameComet.append(comet.getLinks());
                    }

                    @Override
                    public void onFailure(Call<Comet> call, Throwable t) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Error occurred while getting request!", Toast.LENGTH_SHORT);


                    }
                });




    }
}
