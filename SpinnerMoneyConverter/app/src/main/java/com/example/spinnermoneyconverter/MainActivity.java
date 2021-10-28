package com.example.spinnermoneyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    //currency data
    private String names[] = {"EUR", "USD", "GBP", "INR", "CNY", "RON"};
    private Double rates [] = {1., 1.23, 0.89, 90.12, 7.6, 5.23};


    //objects
    private Spinner fromSpinner, toSpinner;
    private EditText fromEditText, toEditText;
    private Button convertButton, clearButton;
    private ArrayAdapter<String> adapter = null;

    private int toSpinnerIndex, fromSpinnerIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //wire components
        fromSpinner = findViewById(R.id.spinner1);
        toSpinner = findViewById(R.id.spinner2);

        fromEditText = findViewById(R.id.editTextTextPersonName1);
        toEditText = findViewById(R.id.editTextTextPersonName2);

        convertButton = findViewById(R.id.button1);
        clearButton = findViewById(R.id.button2);

        //adapter
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, names);

        fromSpinner.setAdapter(adapter);
        toSpinner.setAdapter(adapter);

        //listeners for spinners
        fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                fromSpinnerIndex = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        toSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                toSpinnerIndex = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get exchange from fromSpinnerIndex, toSpinnerIndex
                double rate = rates[toSpinnerIndex] / rates[fromSpinnerIndex];
                //toEditText.setText(String.valueOf(rate));
                System.out.println(rate);

                //get amount to convert from
                Double finalRate = Double.parseDouble(fromEditText.getText().toString());
                System.out.println(finalRate);
                //calculate the amount to
                double newRate = rate * finalRate;
                toEditText.setText(String.valueOf(newRate));
            }
        });
    }

    public void onClear(View view) {
        fromEditText.setText("");
        toEditText.setText("");
    }
}