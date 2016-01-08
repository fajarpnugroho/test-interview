package com.fslab.android.slimaaroncollection;

import android.app.Application;

import timber.log.Timber;

public class SlimAaronCollectionApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
