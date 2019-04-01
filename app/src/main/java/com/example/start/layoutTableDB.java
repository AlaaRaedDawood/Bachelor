package com.example.start;

import java.util.ArrayList;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//create entity class
@Entity(tableName = "layout_table")
public class layoutTableDB {
    @PrimaryKey(autoGenerate = true)
    private int id ;
    private  String layout_name ;
    private ArrayList<PointF> startPoints = new ArrayList<PointF>();
    private ArrayList<PointF> stopPoints = new ArrayList<PointF>();
   private ArrayList<PointF> resultPoints = new ArrayList<PointF>();
   private int used ;
   public layoutTableDB(String layout_name , ArrayList<PointF>  resultPoints , ArrayList<PointF>  startPoints, ArrayList<PointF>  stopPoints){
       this.resultPoints = resultPoints ;
       this.layout_name = layout_name;
       this.startPoints=startPoints;
       this.stopPoints=stopPoints;
       this.used = 1 ;
   }

    public int getId() {
        return id;
    }

    public ArrayList<PointF> getResultPoints(){

       return resultPoints ;
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
