package com.bluefletch.demo.flavoredapis.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.provider.Settings;
import android.widget.Toast;

import com.bluefletch.demo.flavoredapis.IOverrideSettingsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mattmehalso on 4/23/14.
 */
public class OverrideSettingsAdapter implements IOverrideSettingsAdapter {

    private Context context;

    public OverrideSettingsAdapter(Context context) {
        this.context = context;
    }

    /**
     * Takes the provided package name and activity and attempts to override the existing default for Intent.ACTION_SETTINGS with
     * the provided inputs.
     *
     * @param pkgName
     * @param activity
     */
    @Override
    public void setDefaultSettingsApp(String pkgName, String activity) {
        PackageManager pm = context.getPackageManager();

        IntentFilter filter = new IntentFilter();
        String settingsAction = Settings.ACTION_SETTINGS;

        Intent intent = new Intent(settingsAction);
        intent.addCategory(Intent.CATEGORY_DEFAULT);

        filter.addAction(settingsAction);
        filter.addCategory(Intent.CATEGORY_DEFAULT);

        //Figure out which components are defaults for Intent.ACTION_SETTINGS
        ArrayList<ComponentName> componentNames = new ArrayList<ComponentName>();
        List<ResolveInfo> matchedActivityList = pm.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        for(ResolveInfo matchedActivity : matchedActivityList) {
            //for each, add to list of 'known' Intent.ACTION_SETTINGS components that we want to clear
            ComponentName cn = new ComponentName(matchedActivity.activityInfo.packageName,
                    matchedActivity.activityInfo.name);

            //if the activity returned matches ours, skip it so we don't remove it from defaults
            //if it doesn't match ours, clear any user prefs associated with it
            if(!pkgName.equals(matchedActivity.activityInfo.packageName)) {
                pm.clearPackagePreferredActivities(matchedActivity.activityInfo.packageName);
            }

            componentNames.add(cn);
        }

        // Now add our preferred activity
        pm.addPreferredActivity(filter, IntentFilter.MATCH_CATEGORY_EMPTY,
                componentNames.toArray(new ComponentName[componentNames.size()]),
                new ComponentName(pkgName, activity));

        Toast.makeText(context, "Consider it done... You are now the default Settings.", Toast.LENGTH_LONG).show();
    }
}
