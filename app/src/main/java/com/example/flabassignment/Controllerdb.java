package com.example.flabassignment;

import android.database.sqlite.SQLiteOpenHelper;
import  android.content.Context;
import  android.database.sqlite.SQLiteDatabase;


public class Controllerdb extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME="PersonDatabase";
    public Controllerdb(Context applicationcontext) {
        super(applicationcontext, DATABASE_NAME, null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //create table to insert data
        String query;
        query = "CREATE TABLE IF NOT EXISTS person(Id INTEGER PRIMARY KEY AUTOINCREMENT,FName VARCHAR,LName VARCHAR,Phone VARCHAR, Address VARCHAR);";
        db.execSQL(query);


    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query ;
        query = "DROP TABLE IF EXISTS person";
        db.execSQL(query);
        onCreate(db);
    }



//    @Override
//    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        String query;
//        query = "DROP * FROM person WHERE ID ="+Id;
//        db.execSQL(query);
//        db.close();
//    }
}