package com.example.samarfseifes_2320224934_artspace;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ArtworkDetailsActivity extends AppCompatActivity {

    TextView tvArtworkDetails;
    Button btnVisitWebsite, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artwork_details);

        tvArtworkDetails = findViewById(R.id.tvArtworkDetails);
        btnVisitWebsite = findViewById(R.id.btnVisitWebsite);
        btnBack = findViewById(R.id.btnBack);

        String title = getIntent().getStringExtra("title");
        String artist = getIntent().getStringExtra("artist");
        String year = getIntent().getStringExtra("year");

        tvArtworkDetails.setText(title + "\n" + artist + "\n" + year);

        btnVisitWebsite.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"));
                startActivity(intent);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
