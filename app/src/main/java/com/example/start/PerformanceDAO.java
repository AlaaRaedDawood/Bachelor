package com.example.start;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;
@Dao
public interface PerformanceDAO {
    @Insert
    void insert(PerformanceTableDB performance);
    @Update
    void update(PerformanceTableDB performance);
    @Delete
    void delete(PerformanceTableDB performance);
    @Query("SELECT COUNT (*) FROM performance_table")
    LiveData<Integer> getPerformanceRowsCount();
    @Query("SELECT * FROM performance_table")
    LiveData<List<PerformanceTableDB>> getPerformance();
}
