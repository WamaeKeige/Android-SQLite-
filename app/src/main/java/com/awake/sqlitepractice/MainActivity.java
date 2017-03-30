package com.awake.sqlitepractice;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

import static android.R.attr.value;

public class MainActivity extends AppCompatActivity {
    //declare variabes
    EditText name;
    EditText id;
    EditText phone;
    EditText place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //findview by id
        name = (EditText) findViewById(R.id.name);
        id = (EditText) findViewById(R.id.id);
        place = (EditText) findViewById(R.id.place);
        phone = (EditText) findViewById(R.id.phone);

    }

    public void Add(View view) {
        //save data to SQL
        //creates the database for the fisrt time
        SQLiteDatabase db = this.openOrCreateDatabase("studentDB", MODE_PRIVATE, null);
        //we create a db for the first time only
        db.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR, id INT, place VARCHAR, phone INT);");
//INSERTING DATA INTO OUR DB
        //TO DO insert query
        String inputname = name.getText().toString();
        String inputid = id.getText().toString();
        String inputphone = phone.getText().toString();
        String inputplace = place.getText().toString();

        db.execSQL("INSERT INTO users (name, id, place, phone) VALUES('" + inputname + "', '" + inputid + "', '" + inputplace + "', '" + inputphone + "');");
        //Toast.makeText(MainActivity.this, "Data Entered correctly", Toast.LENGTH_LONG) ;

        Toast.makeText(this, "Data Entered", Toast.LENGTH_SHORT).show();
        Intent x = new Intent(getApplicationContext(),SearchActivity.class);
        startActivity(x);
    }

    private File imageFile;

    public void process(View view) {
        //function for taking images
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        imageFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "test.jpg");
        Uri tempuri = Uri.fromFile(imageFile);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, tempuri);
        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
        startActivityForResult(intent, 0);
    }
    public void Search(View view) {
     Intent intent =  new Intent(this,SearchActivity.class);
        startActivity(intent);
    }

    public void Delete(View view) {
        Intent intent = new Intent(this,DeleteActivity.class);
        startActivity(intent);
    }
}
