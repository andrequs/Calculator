package com.example.admin.nyproject.data.model;
import android.support.annotation.NonNull;


public class Board {
    private static final float MM_TO_METER = 1000f;
    private static final float CM_TO_METER = 100f;
    private float width;
    private float length;
    private float thickess;



    public Board (@NonNull float mWidth, float mLenth, float mThickness){
        width = mWidth;
        length = mLenth;
        thickess = mThickness;
    }

    public float getWidth(){
        return width;
    }

    public float getLength(){
        return length;
    }

    public float getThickess(){
        return thickess;
    }

    public float boardSum(float width, float lenth, float thickess){
        float sum = (width / CM_TO_METER) * lenth * (thickess / MM_TO_METER);
        return sum;
    }

}
