package com.tan.android.music.model;

/**
 * Created by tanchunmao on 6/22/15.
 * _id:1,album_artist:李春波,album_name:小芳,album_timestamp:1391350244225,
 */
public class Album extends Data{
    private String album_artist;
    private String album_name;
    private long album_timestamp;

    private String albumPath;

    public String getAlbumPath() {
        return albumPath;
    }

    public void setAlbumPath(String albumPath) {
        this.albumPath = albumPath;
    }

    public String getAlbum_artist() {
        return album_artist;
    }

    public void setAlbum_artist(String album_artist) {
        this.album_artist = album_artist;
    }

    public String getAlbum_name() {
        return album_name;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }

    public long getAlbum_timestamp() {
        return album_timestamp;
    }

    public void setAlbum_timestamp(long album_timestamp) {
        this.album_timestamp = album_timestamp;
    }
}
