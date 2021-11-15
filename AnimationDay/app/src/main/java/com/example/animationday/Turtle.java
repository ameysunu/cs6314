package com.example.animationday;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

public class Turtle {

    private Canvas canvas;
    private Paint paint;

    private float x, y; double dir;

    private int pen;

    public Turtle(Canvas c, Paint p)
    {
        Log.d("[[Debug]]", "Turtle Object created");

        canvas = c; paint = p;
        x = y =  0;

        dir = 0;
        pen = 1;
    }

    public void  left(double angle){dir+=angle;}
    public void right(double angle){dir-=angle;}

    public void moveTo(float x0, float y0){x = x0; y = y0; }
    public void moveTo(float x0, float y0, double d){x = x0; y = y0; dir = d;}


    public void   up(){pen = 0;}
    public void down(){pen=1;}

    public void forward(float length)
    {
        float x1 = (float)(x + length * Math.cos(dir));
        float y1 = (float)(y + length * Math.sin(dir));

        if(pen == 1)
        {
            canvas.drawLine(x, y, x1, y1, paint);

            //Log.d("[[Debug]]", "Forward for " + x + " "+ y + " "+ x1 + " "+ y1 + " ");

        }
        x=x1;y=y1;
    }

    public void backward(float length){forward(-length);}



}