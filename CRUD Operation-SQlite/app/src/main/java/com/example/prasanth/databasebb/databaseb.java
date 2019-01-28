package com.example.prasanth.databasebb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class databaseb extends SQLiteOpenHelper {

    SQLiteDatabase sqLiteDatabase;

    public databaseb(Context context) {
        super(context, "Students.db", null,1);
        sqLiteDatabase=getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table details(Name text,Location text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long saveit(String s1,String s2){

        ContentValues contentValues=new ContentValues();
        contentValues.put("Name",s1);
        contentValues.put("Location",s2);
        long k=sqLiteDatabase.insert("details",null,contentValues);
        return k;

        }


    public String gettt(String s3) {

        Cursor cursor;
        cursor=sqLiteDatabase.query("details",null,"name=?",
                new String[]{s3},null,null,null);

        if (cursor.getCount()<1){

            return "it does not exist";

            }

        cursor.moveToFirst();
        String loc=cursor.getString(cursor.getColumnIndex("Location"));
        return loc;

    }

    public boolean updateit(String s1, String s2) {

        ContentValues contentValues=new ContentValues();
        contentValues.put("Location",s2);
        sqLiteDatabase.update("details",contentValues,"name=?",new String[]{s1});
        return true;
    }

    public Integer deletedatas(String s1) {

        return sqLiteDatabase.delete("details","name=?",new String[]{s1});

    }
}
