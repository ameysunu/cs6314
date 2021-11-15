package com.example.animationday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    private TurtleView view;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        int order = bundle.getInt("order");
        int length = bundle.getInt("length");
        int type = bundle.getInt("type");

        view = new TurtleView(this, order, length, type);
        setContentView(view);
    }
}