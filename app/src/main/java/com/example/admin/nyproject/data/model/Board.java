package com.example.admin.nyproject.data.model;

public class Board {
    private static final float MM_TO_METER = 1000f;
    private static final float CM_TO_METER = 100f;
    private float width;
    private float lenth;
    private float thickess;

    public Board (float mWidth, float mLenth, float mThickness){
        width = mWidth;
        lenth = mLenth;
        thickess = mThickness;
    }

    public float getWidth(){
        return width;
    }

    public float getLenth(){
        return lenth;
    }

    public float getThickess(){
        return thickess;
    }

    public float boardSum(float width, float lenth, float thickess){
        float sum = (width / CM_TO_METER) * lenth * (thickess / MM_TO_METER);
        return sum;
    }

}
