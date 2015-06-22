package com.tan.android.music.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;

import java.io.File;

/**
 * Created by tanchunmao on 6/22/15.
 */
public final class AudioUtil {
    private static final String PATH_MUSIC = "/storage/sdcard1/Music/";
    private static final String PATH_DB = PATH_MUSIC + "songs_.db";
    private static final String PATH_SONG = PATH_MUSIC + "songs/";
    private static final String PATH_ART = PATH_MUSIC + "arts/";
    private static final String PATH_LRC = PATH_MUSIC + "lrcs/";
    private static final String PATH_NEW= PATH_MUSIC + "new/";

    private AudioUtil() {

    }

    public static Audio random() {
        SQLiteDatabase sqLiteDatabase = SQLiteDatabase.openDatabase(PATH_DB, null, SQLiteDatabase.OPEN_READONLY);
        String query = String.format("select * from %1$s , %2$s , %3$s where audio.audio_album_id = album.album_timestamp and audio.audio_artist_id = artist.artist_timestamp ORDER BY RANDOM() LIMIT 1", "audio", "album", "artist");
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        Audio audio = new Audio();
        if (cursor.moveToFirst()) {
            audio.setAudio_title(cursor.getString(cursor.getColumnIndex("audio_title")));
            audio.setFilePath(PATH_SONG + cursor.getLong(cursor.getColumnIndex("audio_timestamp")));
            Album album = new Album();
            album.setAlbum_name(cursor.getString(cursor.getColumnIndex("album_name")));
            album.setAlbumPath(PATH_ART + cursor.getLong(cursor.getColumnIndex("album_timestamp")));
            Artist artist = new Artist();
            artist.setArtist_name(cursor.getString(cursor.getColumnIndex("artist_name")));
            audio.setAlbum(album);
            audio.setArtist(artist);
        }
        cursor.close();
        sqLiteDatabase.close();
        return audio;
    }

    public static void addNew() {
        new AsyncTask<Object, Object,Object>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);
            }

            @Override
            protected Object doInBackground(Object... objects) {
                File[] files = new File(PATH_NEW).listFiles();
                if(files!=null&&files.length>0) {
                    for(File file: files){

                    }
                }
                return null;
            }
        }.execute();
    }

    private static void addNewItem(File file) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(file.getAbsolutePath());
        Audio audio = new Audio();
    }
}
