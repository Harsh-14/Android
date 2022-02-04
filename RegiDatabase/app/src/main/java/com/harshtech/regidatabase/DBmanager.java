package com.harshtech.regidatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBmanager extends SQLiteOpenHelper {
    private final static String dbname="registud.db";
    private final static String tablename="studtable";

    public DBmanager(@Nullable Context context) {
        super(context, dbname,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+tablename+" ( ID INTEGER PRIMARY KEY AUTOINCREMENT ,NAME TEXT ,ADDRESS TEXT,CONTACT TEXT,EMAIL TEXT,DOB TEXT,PASSWORD Text) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+tablename);
        onCreate(sqLiteDatabase);
    }

    public boolean insertdata(String name,String address,String contact,String email,String dob,String password){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put("name",name);
        values.put("address",address);
        values.put("contact",contact);
        values.put("email",email);
        values.put("dob",dob);
        values.put("password",password);


        long result=db.insert(tablename,null,values);
        if (result==-1){
            return false;
        }
        else {
            return true;
        }
    }
    public Cursor fetchdata(String namee){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cr=db.rawQuery("select * from "+tablename+" where NAME "+" = \""+namee+"\"",null);
        return cr;

    }
}
