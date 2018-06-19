package com.example.mariakovaleva.mariasmusicplayer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class SongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        //Get Intent from LibraryActivity
        Intent chooseSongIntent = getIntent();
        Bundle imageId = chooseSongIntent.getExtras();
        //If the song clicked in LibraryActivity was clicked, set album art
        if (imageId != null) {
            ImageView albumArtView = (ImageView) findViewById(R.id.album_art_view);
            albumArtView.setImageResource(imageId.getInt("imageId"));
        }
    }


}
