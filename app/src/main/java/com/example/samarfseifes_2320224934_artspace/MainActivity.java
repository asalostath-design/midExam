package com.example.samarfseifes_2320224934_artspace;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvCounter, tvTitle, tvArtist;
    ImageView ivArtwork;
    Button btnPrevious, btnNext;

    int index = 0;

    int[] images = {R.drawable.starry_night, R.drawable.the_kiss, R.drawable.the_scream,
            R.drawable.girl_with_a_pearl_earring, R.drawable.the_great_wave, R.drawable.mona_lisa};

    String[] titles = {"The Starry Night", "The Kiss", "The Scream",
            "Girl with a Pearl Earring", "The Great Wave off Kanagawa", "Mona Lisa"};

    String[] artists = {"Vincent van Gogh", "Gustav Klimt", "Edvard Munch",
            "Johannes Vermeer", "Katsushika Hokusai", "Leonardo da Vinci"};

    String[] years = {"1889", "1908-1909", "1893", "1665", "1830-1832", "1503-1519"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCounter = findViewById(R.id.tvCounter);
        tvTitle = findViewById(R.id.tvTitle);
        tvArtist = findViewById(R.id.tvArtist);
        ivArtwork = findViewById(R.id.ivArtwork);
        btnPrevious = findViewById(R.id.btnPrevious);
        btnNext = findViewById(R.id.btnNext);

        if (savedInstanceState != null) {
            index = savedInstanceState.getInt("index");
        }

        updateScreen();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index < images.length - 1) {
                    index++;
                    updateScreen();
                }
            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index > 0) {
                    index--;
                    updateScreen();
                }
            }
        });

        ivArtwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ArtworkDetailsActivity.class);
                intent.putExtra("title", titles[index]);
                intent.putExtra("artist", artists[index]);
                intent.putExtra("year", years[index]);
                startActivity(intent);
            }
        });
    }

    void updateScreen() {
        ivArtwork.setImageResource(images[index]);
        tvTitle.setText(titles[index]);
        tvArtist.setText(artists[index] + " (" + years[index] + ")");
        tvCounter.setText((index + 1) + " / " + images.length);

        btnPrevious.setEnabled(index != 0);
        btnNext.setEnabled(index != images.length - 1);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("index", index);
    }
}