package com.bluefletch.demo.flavoredapis.impl;

import android.content.Context;
import android.widget.Toast;

import com.bluefletch.demo.flavoredapis.IOverrideSettingsAdapter;

/**
 * Created by mattmehalso on 4/23/14.
 */
public class OverrideSettingsAdapter implements IOverrideSettingsAdapter {

    private Context context;

    public OverrideSettingsAdapter(Context context) {
        this.context = context;
    }

    @Override
    public void setDefaultSettingsApp(String pkgName, String activity) {
        Toast.makeText(context, "Cool vendor API to override settings happens... NOW!", Toast.LENGTH_LONG).show();
    }
}
