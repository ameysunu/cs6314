package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView value = null;
    private EditText height = null;
    private EditText weight = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        value = findViewById(R.id.textView2);
        height = findViewById(R.id.editTextTextPersonName);
        weight = findViewById(R.id.editTextTextPersonName2);
    }

    public void onClear(View view) {
        value.setText("");
        height.setText("");
        weight.setText("");
    }

    public void onClick(View view) {
        Float h = Float.parseFloat(height.getText().toString());
        Float w = Float.parseFloat(weight.getText().toString());
        Double bmi = w / (Math.pow(h, 2));
        value.setText(bmi.toString());

    }
}