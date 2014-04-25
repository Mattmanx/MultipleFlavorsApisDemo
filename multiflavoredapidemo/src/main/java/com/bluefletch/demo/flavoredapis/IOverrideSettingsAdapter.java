package com.bluefletch.demo.flavoredapis;

/**
 * Created by mattmehalso on 4/23/14.
 */
public interface IOverrideSettingsAdapter {

    /**
     * Should make the provided package/activity component the default settings application.
     * @param pkgName
     * @param activity
     */
    void setDefaultSettingsApp(String pkgName, String activity);
}
