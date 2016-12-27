package com.example.android.miwokapp;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    private MediaPlayer mp;
    AudioManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
        ArrayList<customString> familyMembers = new ArrayList<customString>();
        familyMembers.add(new customString("father", "apa", R.drawable.family_father, R.raw.family_father));
        familyMembers.add(new customString("mother", "ata", R.drawable.family_mother, R.raw.family_mother));
        familyMembers.add(new customString("son", "angsi", R.drawable.family_son, R.raw.family_son));
        familyMembers.add(new customString("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
        familyMembers.add(new customString("older brother", "taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        familyMembers.add(new customString("younger broother", "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        familyMembers.add(new customString("older sister", "tete", R.drawable.family_older_sister, R.raw.family_older_sister));
        familyMembers.add(new customString("younger sister", "kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        familyMembers.add(new customString("grandfather", "ama", R.drawable.family_grandfather, R.raw.family_grandfather));
        familyMembers.add(new customString("grandmother", "na'paapa", R.drawable.family_grandmother, R.raw.family_grandmother));
        WordAdapter itemsAdapter = new WordAdapter(this, familyMembers);

        ListView listView = (ListView) findViewById(R.id.activity_family);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                customString obj = (customString) adapterView.getItemAtPosition(i);
                releaseMediaPlayer();
                am=(AudioManager) getSystemService(Context.AUDIO_SERVICE);
                int result=am.requestAudioFocus(listener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if(result==AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    mp = MediaPlayer.create(FamilyActivity.this, obj.getAudioId());
                    mp.start();

                }
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        releaseMediaPlayer();
                    }
                });

            }
        });

    }

    AudioManager.OnAudioFocusChangeListener listener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int i) {
            switch (i) {
                case AudioManager.AUDIOFOCUS_LOSS:
                    mp.pause();
                    break;
                case AudioManager.AUDIOFOCUS_GAIN_TRANSIENT:
                    mp.pause();
                    break;
                case AudioManager.AUDIOFOCUS_GAIN:
                    mp.seekTo(0);
                    mp.start();
                    break;
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                    mp.pause();
                    break;
            }
        }
    };

    private void releaseMediaPlayer() {
        if (mp != null) {
            mp.release();
            mp = null;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        releaseMediaPlayer();
    }

}
