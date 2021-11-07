package com.example.peopledb;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView view = null;
    private SQLiteDatabase db = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // wire view
        view = findViewById(R.id.textView);

        insertPerson("Joseph Tabirca", "55555555", "", "", "");
        getDBData();
    }

    // db methods to retrieve and insert+update+etc
    void getDBData(){

        String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/peopleDB.sqlite";

        Log.d("DEBUG-->", path);

        // open db
        try{

            db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.CREATE_IF_NECESSARY);

        }catch(Exception e){
            Log.d("DEBUG-->", "ERROR DB CANNOT OPEN " + e.toString());
        }

        // make the query
        String query = "select * from people";
        Cursor cursor = null;
        try{
            cursor = db.rawQuery(query, null);

        }catch(Exception e){
            Log.d("DEBUG-->", "ERROR DB CANNOT QUERY " + e.toString());
        }

        // run the cursor
        int nameColumnID  = cursor.getColumnIndex("name");
        int phoneColumnID = cursor.getColumnIndex("phone");

        String dbText = "";

        while(cursor.moveToNext()){

            String name  = cursor.getString(nameColumnID);
            String phone = cursor.getString(phoneColumnID);

            dbText = dbText + name + " - " + phone + "\n";
        }

        // close db
        db.close();
        view.setText(dbText);
    }

    void insertPerson(String name, String phone, String address, String url, String image){

        // open db
        String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/peopleDB.sqlite";

        // open db
        try{

            db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.CREATE_IF_NECESSARY);

        }catch(Exception e){
            Log.d("DEBUG-->", "ERROR DB CANNOT OPEN " + e.toString());
        }

        // insert person within a transaction
        String args[] = {name, phone, address, url, image};
        String query  = "insert into people (name, phone, address, url, image) values (?,?,?,?,?)";

        db.beginTransaction();
        try{
            db.execSQL(query, args);
            db.setTransactionSuccessful();
        }
        catch(Exception e){
            Log.d("DEBUG-->", "ERROR DB CANNOT EXEC QUERY " + e.toString());
        }
        finally {
            db.endTransaction();
        }


        // close db
        db.close();
    }

}