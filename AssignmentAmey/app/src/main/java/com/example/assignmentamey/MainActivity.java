package com.example.assignmentamey;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView = null;
    private DataAdapter adapter = null;
    private String  names[]=null;
    private XMLData data=null;
    private ImageView imageView=null;
    private TextView textView=null;
    private int[] images = {R.drawable.peter, R.drawable.lois, R.drawable.stewie, R.drawable.brian, R.drawable.glenn, R.drawable.joe};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textView);
        imageView=findViewById(R.id.imageView);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new XMLData(this);
        names = data.getNames();
        PersonDetails[] personDetails = data.getValues();


        adapter = new DataAdapter(personDetails,images,R.layout.cell_layout,this);
        recyclerView.setAdapter(adapter);
    }
}