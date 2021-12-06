package com.example.tema1workoutplan;

import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {PersonVIP.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {
    public  abstract PersonVipDAO personVipDAO();
}
