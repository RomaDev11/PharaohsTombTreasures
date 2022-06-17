package com.UCMobile.in.web;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {
    private static SharedPreferences settingsCrazy = null;
    private static SharedPreferences.Editor editorCrazy = null;
    private static Context contextCrazy = null;


    public static void setContextTomb(Context contextCrazy) {
        SharedPref.contextCrazy = contextCrazy;
    }
    public static void initIdTomb(){
        settingsCrazy = contextCrazy.getSharedPreferences("nn", Context.MODE_PRIVATE);
        editorCrazy = settingsCrazy.edit();
    }

    public static void setStrLineTomb(String key, String value){
        if (settingsCrazy == null) {
            initIdTomb();
        }
        editorCrazy.putString(key, value);
        editorCrazy.commit();
    }

    public static String getStrLineTomb(String key){
        if (settingsCrazy == null) {
            initIdTomb();
        }
        return settingsCrazy.getString(key, null);
    }

}
