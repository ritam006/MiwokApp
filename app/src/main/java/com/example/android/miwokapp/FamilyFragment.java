package com.example.android.miwokapp;


import android.content.Context;
import android.media.AudioManager;
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
public class FamilyFragment extends Fragment {

    private MediaPlayer mp;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.activity_family,container,false);
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
        WordAdapter itemsAdapter = new WordAdapter(getActivity(), familyMembers);

        ListView listView = (ListView) rootView.findViewById(R.id.activity_family);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                customString obj = (customString) adapterView.getItemAtPosition(i);
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
    private void releaseMediaPlayer() {
        if (mp != null) {
            mp.release();
            mp = null;
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
