package com.example.admin.nyproject.data.local.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.Nullable;

import com.example.admin.nyproject.data.model.SpecificationData;

@Database(entities = {SpecificationData.class}, version = 1)

public abstract class JafDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "Boards.db";

    @Nullable
    private static volatile JafDatabase INSTANCE;

    public abstract JafDao jafDao();

    public static JafDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (JafDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            JafDatabase.class, DATABASE_NAME)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

