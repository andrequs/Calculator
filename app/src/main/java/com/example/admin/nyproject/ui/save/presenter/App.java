package com.example.admin.nyproject.ui.save.presenter;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.admin.nyproject.data.local.db.JafDatabase;

public class App extends Application {

    public static App instance;

    private JafDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, JafDatabase.class, "database")
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public JafDatabase getDatabase() {
        return database;
    }

}