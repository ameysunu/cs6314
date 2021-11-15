package com.example.animationclock;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class ClockSurfaceView extends SurfaceView implements Runnable {
    private float length;
    private Thread thread;
    private boolean running = false;
    private SurfaceHolder holder;

    //constructor
    public ClockSurfaceView(Context context, float length) {
        super(context);
        this.length = length;
        holder = getHolder();
    }

    //methods to manage the thread
    public void onResumeClock() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public void onPauseClock() {
        running = false;
        boolean retry = true;
        while (retry) {
            try {
                thread.join();
                retry = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        int sec = 0;
        while (running) {
            if (holder.getSurface().isValid()) {
                //get canvas
                Canvas canvas = holder.lockCanvas();
                //draw the clock
                Paint backPaint = new Paint(); backPaint.setColor(Color.BLACK);
                canvas.drawPaint(backPaint);

                Paint forePaint = new Paint(); forePaint.setColor(Color.WHITE);

                //draw the marks
                RegPoly secMarks = new RegPoly(60, getWidth()/2, getHeight()/2, this.length, canvas, forePaint);
                RegPoly hourMarks = new RegPoly(60, getWidth()/2, getHeight()/2, this.length-10, canvas, forePaint);
                secMarks.drawNodes();
                hourMarks.drawNodes();

                //make 3 regpoly-s for the hand
                RegPoly secHand = new RegPoly(60, getWidth()/2, getHeight()/2, this.length-20, canvas, forePaint);

                //get hour, min, sec from calendar

                // draw the 3 hands
                secHand.drawRadius(sec);

                try {
                    Thread.sleep(1000);
                } catch(Exception e) {

                }
                sec++;

                holder.unlockCanvasAndPost(canvas);
            }
        }
    }
}