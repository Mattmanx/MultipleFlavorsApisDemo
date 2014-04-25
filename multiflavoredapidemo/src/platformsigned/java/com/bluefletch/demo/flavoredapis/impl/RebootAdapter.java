package com.bluefletch.demo.flavoredapis.impl;

import android.content.Context;
import android.os.PowerManager;
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
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        pm.reboot("Because the user asked...");
    }
}
