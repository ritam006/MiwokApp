package com.example.android.miwokapp;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumbersFragment extends Fragment {

    MediaPlayer mp;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.activity_numbers,container,false);
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
        WordAdapter itemsAdapter=new WordAdapter(getActivity(),numbers);

        final ListView listView = (ListView) rootView.findViewById(R.id.activity_numbers);

        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                customString obj=(customString) adapterView.getItemAtPosition(i);
                releaseMediaPlayer();
                mp=MediaPlayer.create(getActivity(),obj.getAudioId());
                mp.start();

                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        releaseMediaPlayer();
                    }
                });

            }
        });
        return rootView;
    }
    private void releaseMediaPlayer(){
        if(mp!=null)
        {
            mp.release();
            mp=null;
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
