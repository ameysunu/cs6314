package com.example.animationday;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText orderEditText, lengthEditText;
    private Button drawButton;
    private Spinner figureSpinner;
    TextView box;

    private String  figures [] = {"Tree", "4-Tree", "Snow Flake", "Gasket", "Gasket"};

    int figureType = 0, figureOrder = 0, figureLength = 0;

    private Intent intent ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // wire UI with widgets
        orderEditText = (EditText) findViewById(R.id.editText1);
        lengthEditText = (EditText) findViewById(R.id.editText2);
        figureSpinner = (Spinner) findViewById(R.id.spinner1);
        drawButton = (Button)findViewById(R.id.button1);

        //Adapter for Spinner

        ArrayAdapter<String> adapter = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, figures);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        figureSpinner.setAdapter(adapter);

        figureSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapter, View v, int pos, long id) {
                // TODO Auto-generated method stub
                figureType = pos;
                Toast.makeText(getApplicationContext(), "Selected figure "+figures[pos], Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        });


        drawButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub


                String str1 = orderEditText.getText().toString();
                String str2 = lengthEditText.getText().toString();

                try{



                    figureOrder = Integer.parseInt(str1);
                    figureLength = Integer.parseInt(str2);

                    Log.i("[[Debug]]","Order is " + figureOrder +" " + str1 + " " + figureLength + str2);
                }
                catch(Exception e)
                {
                    Log.e("[[Error]]", e.getMessage()+" : Parsing Error");
                }


                intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("order", figureOrder);
                intent.putExtra("length", figureLength);
                intent.putExtra("type", figureType);

                Log.i("[[Debug Activity 1]]","Intent Extra are " + figureOrder +" " + figureLength+ " " + figureType);

                startActivity(intent);
                return;

            }

        });


    }

}