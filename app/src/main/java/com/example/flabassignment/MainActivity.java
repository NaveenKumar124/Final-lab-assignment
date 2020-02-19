package com.example.flabassignment;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Controllerdb db =new Controllerdb(this);
    SQLiteDatabase database;
    EditText FName,LName,Phone,Address;
    Button Submitdatabtn,Showdatabtn, delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FName= (EditText) findViewById(R.id.etFName);
        LName= (EditText) findViewById(R.id.etLName);
        Phone= (EditText) findViewById(R.id.etPhone);
        Address= (EditText) findViewById(R.id.etAddress);
        Submitdatabtn= (Button) findViewById(R.id.btnSave);
        Showdatabtn=(Button) findViewById(R.id.btnShow);
        Submitdatabtn.setOnClickListener(this);
        Showdatabtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v)
    {
        if(v.getId()==R.id.btnSave)
        {
            database=db.getWritableDatabase();
            database.execSQL("INSERT INTO person(Fname,LName,Phone,Address)VALUES('"+FName.getText()
                    +"','"+LName.getText()
                    +"','"+Phone.getText()
                    +"','"+Address.getText()
                    +"')" );
            Toast.makeText(this,"Data Inserted To Sqlite Database",Toast.LENGTH_LONG).show();
        }
        else  if(v.getId()==R.id.btnShow)
        {
            Intent intent=new Intent(this,ShowdataListview.class);
            startActivity(intent);

        }else if (v.getId()==R.id.deleteButton){
            Toast.makeText(this,"Deleted",Toast.LENGTH_SHORT).show();
        }

    }
}
