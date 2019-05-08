package com.example.start;

import android.arch.persistence.room.TypeConverter;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class listConverter {

    static Gson gson = new Gson();
    @TypeConverter
    public static ArrayList<PointF> stringToPointFList(String data) {
        Type listType = new TypeToken<ArrayList<PointF>>() {}.getType();
        Log.i("alaa" , "  tttt "+data);
        return new Gson().fromJson(data, listType);



    }

    @TypeConverter
    public static ArrayList<PathLine> stringToPathLineList(String data) {
        Type listType = new TypeToken<ArrayList<PathLine>>() {}.getType();
        Log.i("alaa" , "  tttt "+data);
        return new Gson().fromJson(data, listType);



    }
    @TypeConverter
    public static ArrayList<IntersectedPoints> stringToIntersectedPoints(String data) {
        Type listType = new TypeToken<ArrayList<IntersectedPoints>>() {}.getType();
        Log.i("alaa" , "  tttt "+data);
        return new Gson().fromJson(data, listType);



    }
//    @TypeConverter
//    public static ArrayList<int[]> stringTointarrayList(String data) {
//        Type listType = new TypeToken<ArrayList<int[]>>() {}.getType();
//        Log.i("alaa" , "  tttt "+data);
//        return new Gson().fromJson(data, listType);
//
//
//
//    }
    @TypeConverter
    public static String PointFListToString(ArrayList<PointF>  someObjects) {
        Gson gson = new Gson();
        String json = gson.toJson(someObjects);
        if(json == null ){
            Log.i("alaadbb" , "atfsh5naa");
        }
        return json;
    }
    @TypeConverter
    public static String PathLineListToString(ArrayList<PathLine>  someObjects) {
        Gson gson = new Gson();
        String json = gson.toJson(someObjects);
        if(json == null ){
            Log.i("alaadbb" , "atfsh5naa");
        }
        return json;
    }
    @TypeConverter
    public static String IntersectedPointsListToString(ArrayList<IntersectedPoints>  someObjects) {
        Gson gson = new Gson();
        String json = gson.toJson(someObjects);
        if(json == null ){
            Log.i("alaadbb" , "atfsh5naa");
        }
        return json;
    }
//    @TypeConverter
//    public static String IntarrayListToString(ArrayList<int[]>  someObjects) {
//        Gson gson = new Gson();
//        String json = gson.toJson(someObjects);
//        if(json == null ){
//            Log.i("alaadbb" , "atfsh5naa");
//        }
//        return json;
//    }
}

