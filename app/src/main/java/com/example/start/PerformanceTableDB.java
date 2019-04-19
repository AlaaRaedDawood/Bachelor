package com.example.start;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


@Entity(tableName = "performance_table")
public class PerformanceTableDB {
    @PrimaryKey(autoGenerate = true)
    private int id ;
    private  String date ;
    private int time ;
    private int user_heartRate ;
    //to be able to know if it is a trial or playinggame
    private int flag ;
    public PerformanceTableDB(String date,int time , int user_heartRate, int flag){
        this.date=date;
        this.time = time ;
        this.user_heartRate = user_heartRate;
        this.user_heartRate = user_heartRate ;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getFlag() {
        return flag;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public int getTime() {
        return time;
    }

    public int getUser_heartRate() {
        return user_heartRate;
    }
}
