package com.example.mariakovaleva.mariasmusicplayer;

public class Song {

    private String mArtistName = "";
    private String mSongName = "";
    private int mAlbumCoverResourceId = 0;

    public Song(String artistName, String songName, int albumCover) {
        mArtistName = artistName;
        mSongName = songName;
        mAlbumCoverResourceId = albumCover;
    }

    public String getArtistName() {
        return mArtistName;
    }

    public String getSongName() {
        return mSongName;
    }

    public int getAlbumCoverResourceId() {
        return mAlbumCoverResourceId;
    }
}
