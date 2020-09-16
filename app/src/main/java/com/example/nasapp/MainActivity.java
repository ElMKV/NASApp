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

public class MainActivity extends AppCompatActivity {

    TextView textViewName;
    TextView textViewData;
    TextView textViewDesc;
    ImageView imageView;
    private String KEY = "1gzGfmSJbbcPKLiDyd59NHKlQhXSD8iAbGnezrDS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textViewName = (TextView) findViewById(R.id.textViewTitle);
        textViewData = (TextView) findViewById(R.id.textViewData);
        textViewDesc = (TextView) findViewById(R.id.textViewDesc);
        imageView = (ImageView) findViewById(R.id.imageView);
        NetworkService.getInstance()
                .getJSONApi()
                .getPostWithID(KEY)
                .enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(@NonNull Call<Post> call, @NonNull Response<Post> response) {
                        Post post = response.body();

                        textViewName.append(post.getTitle());
                        textViewData.append(post.getDate());
                        textViewData.append(post.getExplanation());

                        Picasso.with(getApplicationContext())
                                .load(post.getUrl())
                                .placeholder(R.drawable.ic_launcher_background)
                                .error(R.drawable.ic_launcher_foreground)
                                .into(imageView);

                    }

                    @Override
                    public void onFailure(@NonNull Call<Post> call, @NonNull Throwable t) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Error occurred while getting request!", Toast.LENGTH_SHORT);
                        t.printStackTrace();
                    }
                });

    }


}