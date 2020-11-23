package com.example.testapp;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Properties;

public final class Helper {
    private static final String TAG = "Helper";

    public enum LogType {
        ERR,
        INFO,
        NONE,
    }


    public static String getConfigValue(Context context, String name) {
        try {
            Resources resources = context.getResources();
            InputStream rawResource = resources.openRawResource(R.raw.config);
            Properties properties = new Properties();
            properties.load(rawResource);
            rawResource.close();
            return properties.getProperty(name);
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Unable to find the config file: " + e.getMessage());
        } catch (IOException e) {
            Log.e(TAG, "Failed to open config file\n" + e.getMessage());
        }
        return null;
    }

    public static void setConfigValue(Context context, String name, String value) {
        try {
            Resources resources = context.getResources();
            FileOutputStream rawResource = new FileOutputStream(resources.getResourceName(R.raw.config));
            Properties properties = new Properties();
            properties.setProperty(name, value);
            properties.store(rawResource, "");
            rawResource.close();
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Unable to find the config file: " + e.getMessage());
        } catch (IOException e) {
            Log.e(TAG, "Can't write to config file.\n" + e.getMessage());
        }
    }

    public static void messageLogger(Context context, LogType logType,String tag, String msg) {
        switch (logType){
            case ERR:
                Log.e(tag, msg);
                break;
            case INFO:
                Log.i(tag, msg);
                break;
            case NONE:
                break;
        }
        Toast toast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
    }
}