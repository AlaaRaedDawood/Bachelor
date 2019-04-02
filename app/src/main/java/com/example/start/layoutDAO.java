package com.example.start;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;



@Dao
public interface layoutDAO {
    //specifing the return type , the method and the parameter and it's equvalent method (@method)in db
    @Insert
    void insert(layoutTableDB layout);
    @Update
    void update(layoutTableDB layout);
    @Delete
    void delete(layoutTableDB layout);
    @Query("DELETE FROM layout_table")
    void deleteAllNotes();
    @Query("SELECT * FROM layout_table")
    LiveData<List<layoutTableDB>> getAllLayout();
}
