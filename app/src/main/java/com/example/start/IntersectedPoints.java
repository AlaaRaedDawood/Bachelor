package com.example.start;

import android.graphics.Point;

public class IntersectedPoints  implements java.io.Serializable {
    private PointF point ;
    private int indexOfLine1 ;
    private int indexOfLine2 ;
    private int Id  = 0;
    public IntersectedPoints(PointF point , int indexOfLine1 , int indexOfLine2 , int Id ){
        this.point = point ;
        this.indexOfLine1 = indexOfLine1 ;
        this.indexOfLine2 = indexOfLine2 ;
        this.Id =  Id  ;

    }
    public PointF getPoint(){
        return point ;
    }
    public int getIndexOfLine1(){
        return indexOfLine1 ;
    }
    public int getIndexOfLine2(){
        return indexOfLine2 ;
    }
    public int getId(){
        return  Id ;
    }
}