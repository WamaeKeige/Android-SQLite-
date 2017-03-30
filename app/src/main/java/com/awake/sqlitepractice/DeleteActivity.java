package com.awake.sqlitepractice;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static com.awake.sqlitepractice.R.id.idsearch;

public class DeleteActivity extends AppCompatActivity {
EditText txtdelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        txtdelete= (EditText) findViewById(R.id.txtdelete);
    }

    public void Delete(View view) {
        //deletes data from db
        SQLiteDatabase db = this.openOrCreateDatabase("studentDB", MODE_PRIVATE, null);
        //this method returns results
        String inputid = txtdelete.getText().toString();
        //idsearch ahs been passed into a string
        // this method returns a cursor- a cursor returns rows

        int x = db.delete("users","id="+inputid,null);
        //check empty cursor
        if (x == 0) {
            Toast.makeText(this, "Nothing to Delete", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, " Delete", Toast.LENGTH_SHORT).show();           }
}}