package com.tan.android.music.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tan.android.music.R;
import com.tan.android.music.model.Audio;

public class PlayingActivity extends Activity {
    public static final String TAG = "tan_music";
    private Audio audio;
    private ImageView albumIconView;
    private TextView titleView;
    private TextView albumNameView;
    private TextView artistNameView;
    private TextView playView;
    private View nextView;
    private boolean paused;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);

        startService(new Intent(this, PlayingService.class));
        albumIconView = (ImageView) findViewById(R.id.image_album);
        titleView = (TextView) findViewById(R.id.label_title);
        albumNameView = (TextView) findViewById(R.id.label_album);
        artistNameView = (TextView) findViewById(R.id.label_artist);
        playView = (TextView) findViewById(R.id.click_play);
        nextView = findViewById(R.id.click_next);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        albumIconView.getLayoutParams().height = size.x;

        playView.setOnClickListener(onClickListener);
        nextView.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.equals(playView)) {
                paused = !paused;
                playView.setText(paused ? "play" : "pause");
                Intent intent = new Intent(PlayingService.ACTION_PAUSE);
                intent.putExtra(Boolean.class.getName(), paused);
                sendBroadcast(intent);
            } else if (view.equals(nextView)) {
                sendBroadcast(new Intent(PlayingService.ACTION_NEXT));
            }
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PlayingService.ACTION_SONG);
        registerReceiver(broadcastReceiver, intentFilter);

    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (PlayingService.ACTION_SONG.equals(intent.getAction())) {
                audio = (Audio) intent.getSerializableExtra(Audio.class.getName());
                updateDisplay();
            }
        }
    };

    private void updateDisplay() {
        playView.setText("pause");
        albumIconView.setImageBitmap(BitmapFactory.decodeFile(audio.getAlbum().getAlbumPath()));
        titleView.setText(audio.getAudio_title());
        albumNameView.setText(audio.getAlbum().getAlbum_name());
        artistNameView.setText(audio.getArtist().getArtist_name());
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);
    }
}
