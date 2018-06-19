package com.example.nikhil.moviedb;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class DetailActivity extends AppCompatActivity {

    ImageView imageView;


    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageView = findViewById(R.id.d_img);


        textView = findViewById(R.id.d_multiTv);

        //Receive data

        Intent intent = getIntent();

        String Url =  intent.getExtras().getString("Photo");

        String final_url = "https://image.tmdb.org/t/p/h632/"+Url;


        String description = intent.getExtras().getString("Desc");


        Glide.with(getApplicationContext()).load(final_url)
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=cxLG2wtE7TM")));

                Toast.makeText(getApplicationContext(),"Clicked",Toast.LENGTH_LONG).show();
            }
        });

        textView.setText(description);
        textView.setMovementMethod(new ScrollingMovementMethod());


    }
}
