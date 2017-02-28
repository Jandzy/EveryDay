package com.jandzy.everyday.feb.day28;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.drawable.PictureDrawable;
import android.util.AttributeSet;
import android.view.View;

/**
 * canvas picture
 */

public class CanvasPictureView extends View {

    private Picture mPicture;

    public CanvasPictureView(Context context) {
        super(context);
        recoid();
    }

    public CanvasPictureView(Context context, AttributeSet attrs) {
        super(context, attrs);
        recoid();
    }

    public CanvasPictureView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CanvasPictureView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /**
     * picture 相当于录制过程，并不会直接显示，需要调用picture的draw方法来绘制
     */
    private void recoid(){
        mPicture = new Picture();
        Canvas canvas = mPicture.beginRecording(500, 500);


        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        canvas.translate(250,250);
        canvas.drawCircle(0,0,100,paint);

        mPicture.endRecording();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //picture的draw方法     切记：     android:hardwareAccelerated="false"
        mPicture.draw(canvas);

        canvas.translate(100,100);

        //picture转换成picturedrawalbe
        PictureDrawable pictureDrawable = new PictureDrawable(mPicture);
        pictureDrawable.setBounds(0,0,mPicture.getWidth(),mPicture.getHeight()/2);
        pictureDrawable.draw(canvas);

        canvas.translate(0,200);

        //canvas的drawPicture方法
        canvas.drawPicture(mPicture,new Rect(0,0,mPicture.getWidth()/2,mPicture.getHeight()));

        //cavas 的 drawBitmap

    }
}
