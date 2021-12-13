package com.example.tema1workoutplan;

import android.content.Context;

import androidx.room.Room;

public class DatabaseAcces {

    private Database db;

    private DatabaseAcces(Context context) {

        db = Room.databaseBuilder(context, Database.class, "dbhomework").allowMainThreadQueries().build();

    }

    private static DatabaseAcces instance;

    public static DatabaseAcces getInstance(Context context) {
        if(instance == null) {
            instance = new DatabaseAcces(context);
        }
        return instance;
    }

    public Database getDatabase() { return db; }
}
