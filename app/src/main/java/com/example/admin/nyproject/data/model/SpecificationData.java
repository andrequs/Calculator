package com.example.admin.nyproject.data.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Specification")
public class SpecificationData {

    @PrimaryKey
    @ColumnInfo(name = "Number")
    private int mNumber;

    @ColumnInfo(name = "Grade")
    private String mGrade;

    @ColumnInfo(name = "Quantity")
    private int mQuantity;

    @ColumnInfo(name = "Volume")
    private float mVolume;

    @Ignore
    public SpecificationData() {
    }

    public SpecificationData(int number, String grade, int quantity, float volume) {
        mNumber = number;
        mGrade = grade;
        mQuantity = quantity;
        mVolume = volume;
    }

    public int getNumber() {
        return mNumber;
    }

    public void setNumber(int number) {
        mNumber = number;
    }

    public String getGrade() {
        return mGrade;
    }

    public void setGrade(String grade) {
        mGrade = grade;
    }

    public int getQuantity() {
        return mQuantity;
    }

    public void setQuantity(int quantity) {
        mQuantity = quantity;
    }

    public float getVolume() {
        return mVolume;
    }

    public void setVolume(float volume) {
        mVolume = volume;
    }
}
