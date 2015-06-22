package com.tan.android.music.activity;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import com.tan.android.music.model.Audio;
import com.tan.android.music.model.AudioUtil;

import java.io.IOException;

/**
 * Created by tanchunmao on 6/22/15.
 */
public class PlayingService extends Service {
    private MediaPlayer mediaPlayer;
    public static final String ACTION_SONG = "song";
    public static final String ACTION_PAUSE = "pause";
    public static final String ACTION_NEXT = "next";
    private Audio audio;

    @Override
    public void onCreate() {
        super.onCreate();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_PAUSE);
        intentFilter.addAction(ACTION_NEXT);
        registerReceiver(broadcastReceiver, intentFilter);

        initMediaPlayer();
        next();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (ACTION_PAUSE.equals(intent.getAction())) {
                boolean paused = intent.getBooleanExtra(Boolean.class.getName(), false);
                if (paused) {
                    mediaPlayer.pause();
                } else {
                    mediaPlayer.start();
                }
            } else if (ACTION_NEXT.equals(intent.getAction())) {
                next();
            }
        }
    };

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);

    }

    private void initMediaPlayer() {
        mediaPlayer = new MediaPlayer();

    }

    private void next() {
        audio = AudioUtil.random();
        try {
            mediaPlayer.reset();
            mediaPlayer.setDataSource(audio.getFilePath());
            Log.d("tan_music",audio.getFilePath());
            mediaPlayer.prepare();
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    next();
                }
            });

            Intent intent = new Intent(ACTION_SONG);
            intent.putExtra(Audio.class.getName(), audio);
            sendBroadcast(intent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
