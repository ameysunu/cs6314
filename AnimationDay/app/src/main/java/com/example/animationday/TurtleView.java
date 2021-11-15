package com.example.animationday;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class TurtleView extends View {

    Context context;
    int order, type;
    float length;

    public TurtleView(Context context, int order, float length, int type) {
        super(context);

        this.context = context;
        this.order = order;
        this.length = length;
        this.type = type;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //get ready to draw
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(3);
        Turtle t = new Turtle(canvas, paint);

        //draw
        switch (this.type){
            case 0: //binary tree
                t.moveTo(this.getWidth()/2, this.getHeight(), -Math.PI/2);
                tree(this.order, this.length, t);
                break;

            case 1: //dandelion tree
                t.moveTo(this.getWidth()/2, this.getHeight(), -Math.PI/2);
                tree4(this.order, this.length, t);
                break;

            case 2:
                t.moveTo(this.getWidth()/2, this.getHeight()/2, -Math.PI/2);
                flake(this.order, this.length, t);
                break;

        }
    }
    void tree(int n, float l, Turtle t){
        //termination
        if (n==0 || l<2) return;

        //recursion
        t.forward(l);
        t.left(Math.PI/4);
        tree(n-1,l/2, t);
        t.right(Math.PI/2);
        tree(n-1, l/2, t);
        t.left(Math.PI/4);
        t.backward(l);

    }

    void tree4(int n, float l, Turtle t){
        //termination
        if (n==0 || l<2) return;

        //recursion
        t.forward(l);
        t.left(Math.PI/2);
        tree4(n-1,l/2, t);
        t.right(Math.PI/3);
        tree4(n-1, l/2, t);
        t.right(Math.PI/3);
        tree4(n-1, l/2, t);
        t.right(Math.PI/3);
        tree4(n-1, l/2, t);
        t.left(Math.PI/2);
        t.backward(l);

    }

    void koch(int n, float l, Turtle t){
        if(n==0 || l<2){
            t.forward(l);
            return;
        }
        koch(n-1, l/3, t);
        t.left(Math.PI/3);
        koch(n-1,l/3, t);
        t.right(Math.PI/3);
        koch(n-1,l/3,t);
        t.left(Math.PI/3);
        koch(n-1,l/3,t);
    }

    void flake(int n, float l, Turtle t){
        for(int i=0;i<3;i++){
            koch(n, l, t);
            t.right(2*Math.PI/3);
        }
    }
}
