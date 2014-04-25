package com.bluefletch.demo.flavoredapis.impl;

import android.app.AlarmManager;
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
        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        am.setTime(epochTimeMS);
        Toast.makeText(context, "Time has been set! Check the top right.", Toast.LENGTH_LONG).show();
    }
}
