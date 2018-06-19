package com.example.mariakovaleva.mariasmusicplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

public class PlayerFragment extends Fragment {

    private static View mFragmentView;
    private MediaPlayer mediaPlayer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

       mediaPlayer = MediaPlayer.create(getContext(), R.raw.promise_reprise);

        if (mFragmentView != null) {

            ViewGroup parent = (ViewGroup) mFragmentView.getParent();

            if (parent != null)
                parent.removeView(mFragmentView);

        }

        try {
            // Inflate the layout for this fragment
            mFragmentView = inflater.inflate(R.layout.activity_player_fragment, container, false);

            //The leftmost button which switches the view from LibraryActivity to SongActivity and back
            ImageButton showCurrentSong = (ImageButton) mFragmentView.findViewById(R.id.show_current_song);

            showCurrentSong.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (getActivity() instanceof LibraryActivity) {

                        Intent songIntent = new Intent(getActivity(), SongActivity.class);
                        startActivity(songIntent);
                    } else if (getActivity() instanceof SongActivity) {

                        Intent songIntent = new Intent(getActivity(), LibraryActivity.class);
                        startActivity(songIntent);
                    }
                }

            });

            final ImageButton playPauseButton = (ImageButton) mFragmentView.findViewById(R.id.play_pause_button);

            playPauseButton.setImageResource(R.drawable.ic_action_playback_play);
            if (LibraryActivity.isMusicPlaying == true) {
                playPauseButton.setImageResource(R.drawable.ic_action_playback_pause);
            }


            playPauseButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (!mediaPlayer.isPlaying()) {
                        LibraryActivity.isMusicPlaying = true;
                        playPauseButton.setImageResource(R.drawable.ic_action_playback_pause);
                        mediaPlayer.start();
                    } else {
                        LibraryActivity.isMusicPlaying = false;
                        playPauseButton.setImageResource(R.drawable.ic_action_playback_play);
                        mediaPlayer.pause();
                    }


                }
            });

        } catch (InflateException e) {
        }

        ImageButton previousSong = (ImageButton) mFragmentView.findViewById(R.id.jump_to_beginning);

        previousSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mediaPlayer.seekTo(0);
            }
        });

        ImageButton nextSong = (ImageButton) mFragmentView.findViewById(R.id.jump_to_middle);

        nextSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.seekTo(mediaPlayer.getDuration()/2);
            }
        });

        return mFragmentView;

    }

}
