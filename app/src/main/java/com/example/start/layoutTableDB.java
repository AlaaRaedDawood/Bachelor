package com.example.start;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;

import java.util.ArrayList;


//create entity class
@Entity(tableName = "layout_table")

public class layoutTableDB  implements java.io.Serializable{
    @PrimaryKey(autoGenerate = true)
    private int id ;
    private  String layout_name ;

    public ArrayList<PointF> startPoints = new ArrayList<PointF>();
    private ArrayList<PointF> stopPoints = new ArrayList<PointF>();
   private ArrayList<PointF> intersectPoints = new ArrayList<PointF>();
   private ArrayList<PathLine> pathLines = new ArrayList<PathLine>();
   private int used ;



    public layoutTableDB(String layout_name , ArrayList<PathLine> pathLines , ArrayList<PointF>  intersectPoints , ArrayList<PointF>  startPoints, ArrayList<PointF>  stopPoints){
       this.intersectPoints = intersectPoints ;
       this.pathLines = pathLines ;
       this.layout_name = layout_name;
       this.startPoints=startPoints;
       this.stopPoints=stopPoints;
       this.used = 1 ;
   }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public ArrayList<PointF> getIntersectPoints(){

       return intersectPoints ;
    }
    public ArrayList<PathLine> getPathLines() {
        return pathLines;
    }
    public ArrayList<PointF> getStartPoints(){
        return startPoints ;
    }
    public ArrayList<PointF> getStopPoints(){

       return stopPoints ;
    }
    public String getLayout_name(){

       return layout_name ;
    }
    public void setUsed(int x){

       this.used = x ;
    }
    public int getUsed(){

       return used ;
    }
}
