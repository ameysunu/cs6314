package com.example.animationclock;

import android.graphics.Canvas;
import android.graphics.Paint;

public class RegPoly {
    //give instance variables
    private int n;
    private float x0, y0, r;
    private float x[], y[];
    private Canvas canvas; private Paint paint;
    //constructor
    public RegPoly(int n, float x0, float y0, float r, Canvas canvas, Paint paint) {
        this.n = n;
        this.x0 = x0;
        this.y0 = y0;
        this.r = r;
        this.canvas = canvas;
        this.paint = paint;

        //calculate x[] and y[]

        this.x = new float[this.n];
        this.y = new float[this.n];
        for(int i=0;i<n;i++)
        {
            this.x[i] = (float) (x0 + r * Math.cos(2*Math.PI*i/n));
            this.y[i] = (float) (y0 + r * Math.sin(2*Math.PI*i/n));
        }
    }

    public float getX(int i) {
        return this.x[i%this.n];
    }

    public float getY(int i) {
        return this.y[i %this.n];
    }
    //drawers
    public  void drawRadius(int i){
        this.canvas.drawLine(this.x0, this.y0, this.getX(i), this.getY(i), this.paint);
    }

    public void drawNodes()
    {
        for(int i=0;i<this.n;i++)
        {
            this.canvas.drawCircle(this.getX(i), this.getY(i), 4, this.paint);
        }
    }
}


