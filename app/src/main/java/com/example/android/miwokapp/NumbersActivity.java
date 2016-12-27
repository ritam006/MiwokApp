package com.example.android.miwokapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        ArrayList<customString> numbers = new ArrayList<customString>();
        numbers.add(new customString("one", "lutti",R.drawable.number_one,R.raw.number_one));
        numbers.add(new customString("two", "otiiko",R.drawable.number_two,R.raw.number_two));
        numbers.add(new customString("three", "tolookosu",R.drawable.number_three,R.raw.number_three));
        numbers.add(new customString("four", "oyyisa",R.drawable.number_four,R.raw.number_four));
        numbers.add(new customString("five", "massokka",R.drawable.number_five,R.raw.number_five));
        numbers.add(new customString("six", "temmokka",R.drawable.number_six,R.raw.number_six));
        numbers.add(new customString("seven", "kenekaku",R.drawable.number_seven,R.raw.number_seven));
        numbers.add(new customString("eight", "kawinta",R.drawable.number_eight,R.raw.number_eight));
        numbers.add(new customString("nine", "wo'e",R.drawable.number_nine,R.raw.number_nine));
        numbers.add(new customString("ten", "na'aacha",R.drawable.number_ten,R.raw.number_ten));
        WordAdapter itemsAdapter=new WordAdapter(this,numbers);

        final ListView listView = (ListView) findViewById(R.id.activity_numbers);

        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                customString obj=(customString) adapterView.getItemAtPosition(i);
                releaseMediaPlayer();
                mp=MediaPlayer.create(NumbersActivity.this,obj.getAudioId());
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
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

}



