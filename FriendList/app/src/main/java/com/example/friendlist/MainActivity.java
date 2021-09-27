package com.example.friendlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //recyclerview obj

    private RecyclerView recyclerView = null;
    private DataAdapter adapter = null;
    private String names[] = {"Dog", "Doggo", "Doge"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //wire recyclerView
        recyclerView = findViewById(R.id.recyclerView);

        //adapter
        adapter = new DataAdapter(names, this, R.layout.row_layout);
        recyclerView.setAdapter(adapter);
    }
}