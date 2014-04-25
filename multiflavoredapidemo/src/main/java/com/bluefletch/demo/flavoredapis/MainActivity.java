package com.bluefletch.demo.flavoredapis;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.Toast;

import com.bluefletch.demo.flavoredapis.impl.OverrideSettingsAdapter;
import com.bluefletch.demo.flavoredapis.impl.RebootAdapter;
import com.bluefletch.demo.flavoredapis.impl.TimeAdapter;

import java.util.Date;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button changeTimeButton;
    private Button overrideSettingsButton;
    private Button rebootButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changeTimeButton = (Button) findViewById(R.id.change_time);
        overrideSettingsButton = (Button) findViewById(R.id.override_settings);
        rebootButton = (Button) findViewById(R.id.reboot);

        changeTimeButton.setOnClickListener(this);
        overrideSettingsButton.setOnClickListener(this);
        rebootButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.change_time:
                ITimeAdapter timeAdapter = new TimeAdapter(this);
                Date now = new Date();
                Date anHourFromNow = new Date(now.getTime() + 60 * 60 * 1000);
                timeAdapter.setSystemTime(anHourFromNow.getTime());
                break;
            case R.id.override_settings:
                IOverrideSettingsAdapter settingsAdapter = new OverrideSettingsAdapter(this);
                settingsAdapter.setDefaultSettingsApp(this.getPackageName(), FakeSettingsActivity.class.getName());
                break;
            case R.id.reboot:
                IRebootAdapter rebootAdapter = new RebootAdapter(this);
                rebootAdapter.reboot();
                break;
            default:
                Toast.makeText(this, "How did you get here? That's not a button?", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
