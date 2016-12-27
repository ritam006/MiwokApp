package com.example.android.miwokapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by Ritam Mallick on 19-12-2016.
 */

public class NumberClickActivity implements View.OnClickListener {


    Context context;
    public NumberClickActivity(Context context)
    {
        this.context=context;
    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(context,NumbersActivity.class);
        context.startActivity(intent);
    }
}
