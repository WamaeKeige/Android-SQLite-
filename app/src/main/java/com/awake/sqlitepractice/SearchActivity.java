package com.awake.sqlitepractice;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {

    EditText idsearch;
    TextView tvresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        tvresult = (TextView) findViewById(R.id.tvresult);
        idsearch = (EditText) findViewById(R.id.idsearch);
    }

    public void Search(View view) {
//fetch data from our db.
        //creates or opens new database
        SQLiteDatabase db =this.openOrCreateDatabase("studentDB",MODE_PRIVATE, null);
        //this method returns results
        String inputid = idsearch.getText().toString();
        //idsearch ahs been passed into a string
        // this method returns a cursor- a cursor returns rows

        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE id ='"+inputid+"' ", null);
        //check empty cursor
        if (cursor.getCount()==0){
            Toast.makeText(this, "No Record Found!!!!", Toast.LENGTH_SHORT).show();
        }
        else {
            //gets to display data on the textview
        while (cursor.moveToNext()){
            //there is data that matches and cursor can move to next
            tvresult.append("Name:  "+cursor.getString(0));//first row-first column
            tvresult.append("\nID:    "+cursor.getString(1));//2nd column
            tvresult.append("\nPlace: "+cursor.getString(2));//3rd
            tvresult.append("\nPhone: "+cursor.getString(3));//4th
        }
    }
}}
