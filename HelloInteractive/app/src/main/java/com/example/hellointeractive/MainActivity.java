package com.example.hellointeractive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //declare objects and variables
    private Button helloBt = null;
    private EditText nameET = null;
    private TextView messageTV = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //wire widgets
        helloBt = findViewById(R.id.button2);
        nameET = findViewById(R.id.editTextTextPersonName);
        messageTV = findViewById(R.id.textView3);

        //deal with Button listener
        helloBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get the name from nameET
                String name = nameET.getText().toString();
                // make hello message
                String message = "Hello Android from \n \n" + name;
                // put message to messageTV
                messageTV.setText(message);
            }
        });
    }
}