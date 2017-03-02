package com.jandzy.everyday.feb.day28;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * 简单贝瑟尔学习
 */

public class BesseView extends View implements View.OnTouchListener{


    private Paint mPaint;
    private Point current;
    private Point end;
    private Point start;

    public BesseView(Context context) {
        this(context,null);
    }

    public BesseView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BesseView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr,0);
    }

    public BesseView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.YELLOW);

        start = new Point(100,300);
        end = new Point(500,300);

        current = new Point(100,300);
        setOnTouchListener(this);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        current.x = (int) motionEvent.getX();
        current.y = (int) motionEvent.getY();
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setStrokeWidth(20);
        mPaint.setColor(Color.RED);
        canvas.drawPoint(start.x,start.y,mPaint);
        canvas.drawPoint(end.x,end.y,mPaint);

        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(12);
        mPaint.setStyle(Paint.Style.STROKE);

        Path path = new Path();
        path.moveTo(start.x,start.y);
        path.quadTo(current.x,current.y,end.x,end.y);
        canvas.drawPath(path,mPaint);
    }
}
