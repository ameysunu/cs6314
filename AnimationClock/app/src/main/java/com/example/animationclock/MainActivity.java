package com.example.animationclock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ClockSurfaceView clock = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        clock = new ClockSurfaceView(this, 300);
        setContentView(clock);
    }

    @Override
    protected void onResume(){
        super.onResume();
        clock.onResumeClock();
    }

    @Override
    protected void onPause(){
        super.onPause();
        clock.onPauseClock();
    }
}