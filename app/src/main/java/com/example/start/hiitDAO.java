package com.example.start;

import java.util.ArrayList;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface hiitDAO {
    //specifing the return type , the method and the parameter and it's equvalent method (@method)in db
    @Insert
    void insert(layoutTableDB layout);

    @Update
    void update(layoutTableDB layout);
    @Delete
    void delete(layoutTableDB layout);
    @Query("SELECT * FROM layout_table")
    LiveData<ArrayList<layoutTableDB>> getAllLayout();
}
