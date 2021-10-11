package com.example.personinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.URI;

public class DetailActivity extends AppCompatActivity {

    //objects
    private TextView nameTextView = null;
    private TextView addressTextView = null;
    private TextView phoneTextView = null;
    private TextView urlTextView = null;

    private Button webInfoButton = null;

    private Person data = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //wire
        nameTextView = findViewById(R.id.textView2);
        addressTextView = findViewById(R.id.textView3);
        phoneTextView = findViewById(R.id.textView4);
        urlTextView = findViewById(R.id.textView5);
        webInfoButton = findViewById(R.id.button1);

        //get data from intent
        Intent intent = getIntent();
        data = (Person) intent.getExtras().getSerializable("person");

        //populate widgets with data
        nameTextView.setText(data.getName());
        addressTextView.setText(data.getAddress());
        phoneTextView.setText(data.getPhone());
        urlTextView.setText(data.getUrl());

        webInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(data.getUrl()));
                startActivity(intent);
            }
        });
    }
}