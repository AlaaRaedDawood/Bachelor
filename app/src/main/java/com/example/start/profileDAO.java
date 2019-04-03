package com.example.start;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;



@Dao
public interface profileDAO {
    @Insert
    void insert(ProfileTableDb profile);
    @Update
    void update(ProfileTableDb profile);
    @Delete
    void delete(ProfileTableDb profile);
    @Query("SELECT COUNT (*) FROM profile_table")
    int getProfileRowsCount();
    @Query("SELECT * FROM profile_table")
    LiveData<List<ProfileTableDb>> getProfile();
}
