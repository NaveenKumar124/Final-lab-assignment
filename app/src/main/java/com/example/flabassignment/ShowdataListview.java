package com.example.flabassignment;

import android.app.SearchManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ShowdataListview extends AppCompatActivity {
    Controllerdb controllerdb = new Controllerdb(this);
    SQLiteDatabase db;
    private ArrayList<String> Id = new ArrayList<String>();
    private ArrayList<String> FName = new ArrayList<String>();
    private ArrayList<String> LName = new ArrayList<String>();
    private ArrayList<String> Phone = new ArrayList<String>();
    private ArrayList<String> Address = new ArrayList<String>();
    SearchView searchView;

    Button delete;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdata_listview);
        lv = (ListView) findViewById(R.id.lstvw);
        searchView = (SearchView) findViewById(R.id.searchBar);
        delete = findViewById(R.id.deleteButton);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("List of Persons");
        //getSupportActionBar().setTitle(getTitleColor());


    }

    @Override
    protected void onResume() {

        displayData();
        super.onResume();

    }


    private void displayData() {

        db = controllerdb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM person",null);
        Id.clear();
        FName.clear();
        LName.clear();
        Phone.clear();
        Address.clear();

        if (cursor.moveToFirst()) {

            do {

                Id.add(cursor.getString(cursor.getColumnIndex("Id")));
                FName.add(cursor.getString(cursor.getColumnIndex("FName")));
                LName.add(cursor.getString(cursor.getColumnIndex("LName")));
                Phone.add(cursor.getString(cursor.getColumnIndex("Phone")));
                Address.add(cursor.getString(cursor.getColumnIndex("Address")));
            } while (cursor.moveToNext());

        }

        CustomAdapter ca = new CustomAdapter(ShowdataListview.this,Id, FName,LName,Phone,Address);
        lv.setAdapter(ca);
        //code to set adapter to populate list
        cursor.close();

    }

}
