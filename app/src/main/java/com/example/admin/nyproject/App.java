package com.example.admin.nyproject;

import android.app.Application;
import android.support.annotation.NonNull;

import com.example.admin.nyproject.core.annotation.LateInit;
import com.example.admin.nyproject.data.local.db.JafDatabase;

public class App extends Application {

    @LateInit
    private JafDatabase mJafDatabase;

    //region Application
    @Override
    public void onCreate() {
        super.onCreate();
        mJafDatabase = JafDatabase.getInstance(getApplicationContext());
    }
    //endregion

    //region App
    @NonNull
    public JafDatabase getJafDatabase() {
        return mJafDatabase;
    }
    //endregion
}
