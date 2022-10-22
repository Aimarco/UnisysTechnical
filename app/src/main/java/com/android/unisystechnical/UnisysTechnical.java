package com.android.unisystechnical;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class UnisysTechnical extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        UnisysTechnical.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return UnisysTechnical.context;
    }

    public static boolean isNetwork() {

        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }
}