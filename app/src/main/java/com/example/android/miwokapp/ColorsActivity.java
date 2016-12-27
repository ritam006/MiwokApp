package com.example.android.miwokapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        ArrayList<customString> colors = new ArrayList<customString>();
        colors.add(new customString("red", "wetetti", R.drawable.color_red, R.raw.color_red));
        colors.add(new customString("green", "chokokki", R.drawable.color_green, R.raw.color_green));
        colors.add(new customString("brown", "takaakki", R.drawable.color_brown, R.raw.color_brown));
        colors.add(new customString("gray", "topoppi", R.drawable.color_gray, R.raw.color_gray));
        colors.add(new customString("black", "kululli", R.drawable.color_black, R.raw.color_black));
        colors.add(new customString("white", "kelelli", R.drawable.color_white, R.raw.color_white));
        colors.add(new customString("dusty yellow", "topiise", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        colors.add(new customString("mustard yellow", "chiwiite", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
        WordAdapter itemsAdapter = new WordAdapter(this, colors);

        ListView listView = (ListView) findViewById(R.id.activity_colors);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                customString obj = (customString) adapterView.getItemAtPosition(i);

                releaseMediaPlayer();
                mp = MediaPlayer.create(ColorsActivity.this, obj.getAudioId());
                mp.start();

                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        releaseMediaPlayer();
                        Toast.makeText(ColorsActivity.this, "released", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

    }

    private void releaseMediaPlayer() {
        if (mp != null) {
            mp.release();
            mp=null;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        releaseMediaPlayer();
    }
}

