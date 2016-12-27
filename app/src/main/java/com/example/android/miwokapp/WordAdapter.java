package com.example.android.miwokapp;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ritam Mallick on 19-12-2016.
 */

public class WordAdapter extends ArrayAdapter<customString> {
    public WordAdapter(Context context, ArrayList<customString> list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.custom_layout, parent, false);
        }
        customString string = getItem(position);
        TextView view1 = (TextView) view.findViewById(R.id.textView1);
        view1.setText(string.getString(0));
        TextView view2 = (TextView) view.findViewById(R.id.textView2);
        view2.setText(string.getString(1));
        LinearLayout parentView=(LinearLayout)view.findViewById(R.id.parentView);
        ImageView image=(ImageView)view.findViewById(R.id.play_icon);
        LinearLayout imageParent=(LinearLayout) view.findViewById(R.id.image_parent);
        int id = parent.getId();
        switch (id) {
            case R.id.activity_colors:
                parentView.setBackgroundColor(Color.parseColor("#43A047"));
                image.setBackgroundColor(Color.parseColor("#43A047"));
                imageParent.setBackgroundColor(Color.parseColor("#43A047"));
                break;
            case R.id.activity_family:
                parentView.setBackgroundColor(Color.parseColor("#FB8C00"));
                image.setBackgroundColor(Color.parseColor("#FB8C00"));
                imageParent.setBackgroundColor(Color.parseColor("#FB8C00"));
                break;
            case R.id.activity_phrases:
                parentView.setBackgroundColor(Color.parseColor("#FDD835"));
                image.setBackgroundColor(Color.parseColor("#FDD835"));
                imageParent.setBackgroundColor(Color.parseColor("#FDD835"));
                break;
            case R.id.activity_numbers:
                parentView.setBackgroundColor(Color.parseColor("#E53935"));
                image.setBackgroundColor(Color.parseColor("#E53935"));
                imageParent.setBackgroundColor(Color.parseColor("#E53935"));
                break;
        }
        if (string.getImageid() != 0) {
            ImageView view3 = (ImageView) view.findViewById(R.id.icon);
            view3.setImageResource(string.getImageid());
        } else {
            ImageView view3 = (ImageView) view.findViewById(R.id.icon);
            view3.setVisibility(View.GONE);
        }

        return view;
    }
}
