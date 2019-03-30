package com.example.start;

import java.util.ArrayList;

public class layoutDB {
    private  String layout_name ;
   private ArrayList<PointF> resultPoints = new ArrayList<PointF>();
   public layoutDB(ArrayList<PointF>  resultPoints , String layout_name){
       this.resultPoints = resultPoints ;
       this.layout_name = layout_name;
   }
   public ArrayList<PointF> getResultPoints(){
       return resultPoints ;
   }
    public String getLayout_name(){
        return layout_name ;
    }
}
