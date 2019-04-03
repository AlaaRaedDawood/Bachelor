package com.example.start;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "profile_table")
public class ProfileTableDb {
    @PrimaryKey(autoGenerate = true)
    private int id ;
    private  String user_name ;
    private  String user_gender ;
    private String birthdate ;
    public ProfileTableDb(String user_name, String user_gender ,String birthdate ){
        this.user_name=user_name;
        this.user_gender=user_gender;
        this.birthdate=birthdate;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_gender() {
        return user_gender;
    }

    public String getBirthdate() {
        return birthdate;
    }
}
