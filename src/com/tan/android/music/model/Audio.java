package com.tan.android.music.model;

import android.graphics.Bitmap;

/**
 * Created by tanchunmao on 6/21/15.
 * _id,audio_title,audio_album_id,audio_artist_id,audio_timestamp,audio_count,audio_duration,audio_file,audio_language,audio_tags,audio_bit_rate,audio_year,audio_size,
 * _id,album_artist,album_name,album_timestamp,
 * _id,artist_name,artist_gender,artist_timestamp,artist_area,
 * <p>
 * _id:1,audio_title:小芳,audio_album_id:1391350244225,audio_artist_id:1391350244225,audio_timestamp:1391350244225,audio_count:8,
 * audio_duration:274547,audio_file:1,audio_language:0,audio_tags:,audio_bit_rate:192000,audio_year:1993,audio_size:6616187,
 */
public class Audio extends Data {
    private String audio_title;
    private long audio_album_id;
    private long audio_artist_id;
    private long audio_timestamp;
    private int audio_count;
    private int audio_duration;
    private int audio_file;
    private int audio_language;
    private String audio_tags;
    private int audio_bit_rate;
    private int audio_year;
    private int audio_size;

    private Album album;
    private Artist artist;

    private Bitmap albumBitmap;
    private String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Bitmap getAlbumBitmap() {
        return albumBitmap;
    }

    public void setAlbumBitmap(Bitmap albumBitmap) {
        this.albumBitmap = albumBitmap;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getAudio_title() {
        return audio_title;
    }

    public void setAudio_title(String audio_title) {
        this.audio_title = audio_title;
    }

    public long getAudio_album_id() {
        return audio_album_id;
    }

    public void setAudio_album_id(long audio_album_id) {
        this.audio_album_id = audio_album_id;
    }

    public long getAudio_artist_id() {
        return audio_artist_id;
    }

    public void setAudio_artist_id(long audio_artist_id) {
        this.audio_artist_id = audio_artist_id;
    }

    public long getAudio_timestamp() {
        return audio_timestamp;
    }

    public void setAudio_timestamp(long audio_timestamp) {
        this.audio_timestamp = audio_timestamp;
    }

    public int getAudio_count() {
        return audio_count;
    }

    public void setAudio_count(int audio_count) {
        this.audio_count = audio_count;
    }

    public int getAudio_duration() {
        return audio_duration;
    }

    public void setAudio_duration(int audio_duration) {
        this.audio_duration = audio_duration;
    }

    public int getAudio_file() {
        return audio_file;
    }

    public void setAudio_file(int audio_file) {
        this.audio_file = audio_file;
    }

    public int getAudio_language() {
        return audio_language;
    }

    public void setAudio_language(int audio_language) {
        this.audio_language = audio_language;
    }

    public String getAudio_tags() {
        return audio_tags;
    }

    public void setAudio_tags(String audio_tags) {
        this.audio_tags = audio_tags;
    }

    public int getAudio_bit_rate() {
        return audio_bit_rate;
    }

    public void setAudio_bit_rate(int audio_bit_rate) {
        this.audio_bit_rate = audio_bit_rate;
    }

    public int getAudio_year() {
        return audio_year;
    }

    public void setAudio_year(int audio_year) {
        this.audio_year = audio_year;
    }

    public int getAudio_size() {
        return audio_size;
    }

    public void setAudio_size(int audio_size) {
        this.audio_size = audio_size;
    }


}
