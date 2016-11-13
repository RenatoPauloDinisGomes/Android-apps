package com.gomes.renato.mygym;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Renato on 16/08/2016.
 */
public class PrefClass {
    /**
     * This application's preferences label
     */
    private final String PREFS_NAME = "com.our.package.Workouts";
    /**
     * This application's preferences
     */
    private SharedPreferences settings;
    /**
     * This application's settings editor
     */
    private SharedPreferences.Editor editor;

    /**
     * Constructor takes an android.content.Context argument
     */
    public PrefClass(Context ctx) {
        if (settings == null) {
            settings = ctx.getSharedPreferences(PREFS_NAME,
                    Context.MODE_PRIVATE);
        }
        editor = settings.edit();
    }

    public String getPrefsName() {
        return PREFS_NAME;
    }

    public SharedPreferences getSettings() {
        return settings;
    }


    public SharedPreferences.Editor getEditor() {
        return editor;
    }


}