package com.example.iiitsricity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "Login.db" ,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //creating a table
        db.execSQL("Create table users(email text primary key,password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //dropping table on upgrade
        db.execSQL("drop table if exists users");

    }

    //insert function
    public boolean insert(String email, String password){

        //fetching SQLite database object
        SQLiteDatabase db=this.getWritableDatabase();

        //Creating a content value object
        ContentValues contentValues=new ContentValues();

        //inserting email, password value into content value object
        contentValues.put("email",email);
        contentValues.put("password",password);

        //inserting into the database using content values object
        long flag=db.insert("users",null,contentValues);

        //checking if insertion was successful or not
        if(flag==-1) return false;
        return true;

    }


    //checking if email already exists
    public boolean emailExists(String email){
        SQLiteDatabase db=this.getReadableDatabase();

        //creating a cursor object
        Cursor cursor=db.rawQuery("Select * from users where email=?",new String[]{email});

        if(cursor.getCount()>0)
            return true;
        else
            return false;

    }

    //checks the validity of the credentials
    public boolean checkValidity(String email,String password){

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from users where email=? and password=?",new String[]{email,password});

        if(cursor.getCount()>0)
            return true;
        return false;
    }
}



