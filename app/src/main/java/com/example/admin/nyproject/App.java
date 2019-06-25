package com.example.admin.nyproject;

import android.app.Application;

import com.example.admin.nyproject.data.local.db.JafDatabase;

public class App extends Application {

    private JafDatabase mJafDatabase;

    //region Application
    @Override
    public void onCreate() {
        super.onCreate();
        mJafDatabase = JafDatabase.getInstance(getApplicationContext());
    }
    //endregion

    //region App
    public JafDatabase getJafDatabase() {
        return mJafDatabase;
    }
    //endregion
}
