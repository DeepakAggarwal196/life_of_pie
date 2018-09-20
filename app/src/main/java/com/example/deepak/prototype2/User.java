package com.example.deepak.prototype2;

import android.content.Context;
import android.content.SharedPreferences;

public class User {

    static final String PREFERENCES_NAME = "user_preferences";
    static SharedPreferences pref;
    static SharedPreferences.Editor editor;

    static void INIT_USER(Context context)
    {
        pref = context.getSharedPreferences(PREFERENCES_NAME, 0);
        editor = pref.edit();
    }

    static void clear_preferences()
    {
        editor.clear();
        editor.commit();
    }


    static void putBoolean(String key, boolean value)
    {
        editor.putBoolean(key, value);
        editor.commit();
    }

    static boolean getBoolean(String key, boolean default_value)
    {
        return pref.getBoolean(key, default_value);
    }




    static void putString(String key, String value)
    {
        editor.putString(key, value);
        editor.commit();
    }

    static String getString(String key, String default_value)
    {
        return pref.getString(key, default_value);
    }




    static void putInt(String key, int value)
    {
        editor.putInt(key, value);
        editor.commit();
    }
    static int getInt(String key, int default_value)
    {
        return pref.getInt(key, default_value);
    }





    static void putFloat(String key, float value)
    {
        editor.putFloat(key, value);
        editor.commit();
    }
    static float getFloat(String key, float default_value)
    {
        return pref.getFloat(key, default_value);
    }




    static void putLong(String key, long value)
    {
        editor.putLong(key, value);
        editor.commit();
    }
    static long getLong(String key, long default_value)
    {
        return pref.getLong(key, default_value);
    }

}
