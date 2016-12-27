package com.example.android.miwokapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Phrases extends AppCompatActivity {

    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrase);
        ArrayList<customString> phrases = new ArrayList<>();
        phrases.add(new customString("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
        phrases.add(new customString("What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
        phrases.add(new customString("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
        phrases.add(new customString("How are you feeling?", "michәksәs?", R.raw.phrase_are_you_coming));
        phrases.add(new customString("’m feeling good. k", "kuchi achit", R.raw.phrase_im_feeling_good));
        phrases.add(new customString("Are you coming? ", "әәnәs'aa?", R.raw.phrase_are_you_coming));
        phrases.add(new customString("Yes, I’m coming. ", "hәә’ әәnәm", R.raw.phrase_are_you_coming));
        phrases.add(new customString("I’m coming", "әәnәm", R.raw.phrase_im_coming));
        phrases.add(new customString("Let’s go", "yoowutis", R.raw.phrase_lets_go));
        phrases.add(new customString("Come here. ", "әnni'nem", R.raw.phrase_come_here));
        WordAdapter adapter = new WordAdapter(this, phrases);
        ListView listView = (ListView) findViewById(R.id.activity_phrases);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                customString obj = (customString) adapterView.getItemAtPosition(i);

                releaseMediaPlayer();
                mp = MediaPlayer.create(Phrases.this, obj.getAudioId());
                mp.start();

                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        releaseMediaPlayer();
                    }
                });

            }
        });

    }

    private void releaseMediaPlayer(){
        if(mp!=null)
        {
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
