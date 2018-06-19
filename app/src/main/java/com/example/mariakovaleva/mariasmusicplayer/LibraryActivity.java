package com.example.mariakovaleva.mariasmusicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class LibraryActivity extends AppCompatActivity {

    //Checks if a song is currently playing (play button or item in the ListView in LibraryActivity was clicked)
    public static boolean isMusicPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        //By default, no songs are playing on the start of the application
        isMusicPlaying = false;

        ArrayList<Song> songArrayList = new ArrayList<>();
        songArrayList.addAll(Arrays.asList(
                new Song("Akira Yamaoka", "She", R.drawable.sh1),
                new Song("Akira Yamaoka", "Silent Hill", R.drawable.sh1),
                new Song("Akira Yamaoka", "Not Tomorrow", R.drawable.sh1),
                new Song("Akira Yamaoka", "Theme of Laura", R.drawable.sh2),
                new Song("Akira Yamaoka", "True", R.drawable.sh2),
                new Song("Akira Yamaoka", "Promise (Reprise)", R.drawable.sh2),
                new Song("Melissa Williamson", "You're Not Here", R.drawable.sh3),
                new Song("Melissa Williamson", "Letter From the Lost Days", R.drawable.sh3),
                new Song("Akira Yamaoka", "Save Before You Quit", R.drawable.sh3)
        ));

        SongAdapter songAdapter = new SongAdapter(this, songArrayList);
        final ListView listView = (ListView) findViewById(R.id.song_list_view);

        listView.setAdapter(songAdapter);

        //Intent to change the album art in the SongActivity if an item from the list was clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent chooseSongIntent = new Intent(getApplicationContext(), SongActivity.class);
                isMusicPlaying = true;
                chooseSongIntent.putExtra("imageId", ((Song) listView.getItemAtPosition(position)).getAlbumCoverResourceId());
                getApplicationContext().startActivity(chooseSongIntent);

            }
        });


    }

}
