package com.tan.android.music.model;

/**
 * Created by tanchunmao on 6/22/15.
 *  _id:1,artist_name:李春波,artist_gender:0,artist_timestamp:1391350244225,artist_area:0,
 */
public class Artist extends Data {
    private String artist_name;
    private int artist_gender;
    private long artist_timestamp;
    private int artist_area;

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public int getArtist_gender() {
        return artist_gender;
    }

    public void setArtist_gender(int artist_gender) {
        this.artist_gender = artist_gender;
    }

    public long getArtist_timestamp() {
        return artist_timestamp;
    }

    public void setArtist_timestamp(long artist_timestamp) {
        this.artist_timestamp = artist_timestamp;
    }

    public int getArtist_area() {
        return artist_area;
    }

    public void setArtist_area(int artist_area) {
        this.artist_area = artist_area;
    }
}
