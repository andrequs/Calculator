package com.example.admin.nyproject.data.model;

public class Board {

    private float mLength;
    private float mWidth;
    private float mThickness;

    public Board() {
    }

    public Board(float length, float width, float thickness) {
        mLength = length;
        mWidth = width;
        mThickness = thickness;
    }

    //region Board
    public void setLength(float length) {
        mLength = length;
    }

    public void setWidth(float width) {
        mWidth = width;
    }

    public void setThickness(float thickness) {
        mThickness = thickness;
    }

    public float getLength() {
        return mLength;
    }

    public float getWidth() {
        return mWidth;
    }

    public float getThickness() {
        return mThickness;
    }

    public float cubesOfBoard() {
        return mLength * (mWidth / 100) * (mThickness / 1000);
    }
    //endregion
}
