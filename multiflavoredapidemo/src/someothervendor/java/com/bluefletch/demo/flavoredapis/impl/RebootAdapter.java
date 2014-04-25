package com.bluefletch.demo.flavoredapis.impl;

import android.content.Context;
import android.widget.Toast;

import com.bluefletch.demo.flavoredapis.IRebootAdapter;

/**
 * Created by mattmehalso on 4/23/14.
 */
public class RebootAdapter implements IRebootAdapter {

    private Context context;

    public RebootAdapter(Context context) {
        this.context = context;
    }

    @Override
    public void reboot() {
        Toast.makeText(context, "Cool vendor API to reboot happens... NOW!", Toast.LENGTH_LONG).show();
    }
}
