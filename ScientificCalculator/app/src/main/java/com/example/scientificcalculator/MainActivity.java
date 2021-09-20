package com.example.scientificcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private EditText screen = null;
    private String prevScreenValue = "", currentScreenValue = "", oper = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = findViewById(R.id.editTextTextPersonName);
    }

    public void onClearClick(View view) {
        screen.setText("");
        prevScreenValue = "";
        currentScreenValue = "";
        oper = "";

    }

    public void onEqualClick(View view) {
        //parse screen values to numbers
        Integer.parseInt(currentScreenValue);

        //check oper to compute

        //print result

    }

    public void onOperClick(View view){
        //retain info about oper

        oper = ((Button)view).getText().toString();

        //change screen values
        prevScreenValue = currentScreenValue;
        currentScreenValue = "";
        screen.setText("");
    }

    public void onDigitClick(View view) {
        //append button to screen
        currentScreenValue = currentScreenValue + ((Button)view).getText().toString();
        screen.setText(currentScreenValue);

        // one decimal point

    }
}