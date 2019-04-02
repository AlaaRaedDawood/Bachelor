package com.example.start;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;


@Database(entities = {layoutTableDB.class} ,version = 1)
@TypeConverters(listConverter.class)
public abstract class HiitDB extends RoomDatabase {
    //this variable is created to turn the class singelton
    private static HiitDB instance ;
    //this let us access our dao
    public abstract layoutDAO layoutdao();
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
    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private layoutDAO layoutdao;

        private PopulateDbAsyncTask(HiitDB db) {
            layoutdao = db.layoutdao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
//            noteDao.insert(new Note("Title 1", "Description 1", 1));
//            noteDao.insert(new Note("Title 2", "Description 2", 2));
//            noteDao.insert(new Note("Title 3", "Description 3", 3));
            return null;
        }
    }

}
