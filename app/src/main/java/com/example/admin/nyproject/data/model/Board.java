package com.example.admin.nyproject.data.model;

public class Board {

    private float length;
    private float width;
    private float thickness;

    public  void setLength(float len){ this.length = len;}

    public void setWidth(float wid){
        this.width = wid;
    }

    public void setThickness(float thick){
        this.thickness = thick;
    }

    public float getLength(){ return this.length;}

    public float getWidth(){ return this.width;}

    public float getThickness(){ return this.thickness;}


    public float cubesOfBoard(){
        float cubeOfBoard = length * (width/100) * (thickness/1000);
        return cubeOfBoard;
    }


}
