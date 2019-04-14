package com.example.start;

public class PathLine  implements java.io.Serializable{
    private PointF point1 ;
    private int point1ID ;
    private PointF point2 ;
    private int point2ID ;
    private float size ;
    private int lineId ;
    private boolean checked ;
    public PathLine(PointF point1 ,int point1ID,PointF point2 ,int point2ID , float size , int lineId){
         this.point1 = point1;
         this.point1ID = point1ID ;
        this.point2 = point2;
        this.point2ID = point2ID ;
        this.size = size;
        this.lineId = lineId;
        this.checked = false ;
    }
    public void setSize(float s){
        this.size = s ;
    }
    public PointF getPoint1(){
        return point1 ;
    }
    public PointF getPoint2(){
        return point2 ;
    }
    public int getPoint1ID(){
        return point1ID ;
    }
    public int getPoint2ID(){
        return point2ID ;
    }
    public float getSize(){
        return size ;
    }
    public int getLineid(){
        return lineId ;
    }
    public void setChecked (boolean f){
        checked = f ;
    }
    //check if the pathline alreadyExist
    public boolean checkexist(PathLine p){
        if((this.point1.equals(p.point1))&&(this.point2.equals(p.point2))){
            return true ;
        }
        if((this.point1.equals(p.point2))&&(this.point2.equals(p.point1))){
            return true ;
        }
        return false ;
    }


}
