package com.bluefletch.demo.flavoredapis.impl;

import android.content.Context;
import android.widget.Toast;

import com.bluefletch.demo.flavoredapis.ITimeAdapter;

/**
 * Created by mattmehalso on 4/23/14.
 */
public class TimeAdapter implements ITimeAdapter {

    private Context context;

    public TimeAdapter(Context context) {
        this.context = context;
    }

    @Override
    public void setSystemTime(long epochTimeMS) {
        Toast.makeText(context, "Cool vendor API to set time happens... NOW!", Toast.LENGTH_LONG).show();
    }
}
