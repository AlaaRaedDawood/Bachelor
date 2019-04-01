package com.example.start;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {layoutTableDB.class} ,version = 1)
public abstract class HiitDB extends RoomDatabase {
    //this variable is created to turn the class singelton
    private static HiitDB instance ;
    //this let us access our dao
    public abstract hiitDAO hiitdao();
    //create a database
    public static synchronized HiitDB getInstance(Context context){
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    HiitDB.class, "hiit_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
