package com.example.admin.nyproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "specification";
    public static final String COL_1 = "NUMBER";
    public static final String COL_2 = "GRADE";
    public static final String COL_3 = "QUANTITY";
    public static final String COL_4 = "VOLUME";




    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
          /*db.execSQL("create table if not exists "
                  + TABLE_NAME
                  + "(NUMBER INTEGER , GRADE TEXT, QUANTITY INTEGER, M3 FLOAT)");
    }*/
        final String DATABASE_CREATE_SCRIPT = "create table if not exists "
                + TABLE_NAME + " (" + COL_1
                + " integer , " + COL_2
                + " TEXT, " + COL_3 + " integer, " + COL_4
                + " FLOAT );";
        db.execSQL(DATABASE_CREATE_SCRIPT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String number, String grade, String quantity, String volume){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, number);
        contentValues.put(COL_2, grade);
        contentValues.put(COL_3, quantity);
        contentValues.put(COL_4, volume);
        long res = db.insertOrThrow(TABLE_NAME, null, contentValues);
        db.close();
        if (res == -1)
            return false;
        else
            return true;


    }

    public Cursor getAllData (){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return res;
    }

    public Integer deleteData(String number ){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "NUMBER = ?", new String[]{number});
    }

    public boolean updateData(String number, String grade, String quantity, String volume){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, number);
        contentValues.put(COL_2, grade);
        contentValues.put(COL_3, quantity);
        contentValues.put(COL_4, volume);
        db.update(TABLE_NAME, contentValues, "NUMBER = ?", new String[]{number});
        return true;
    }



}
//