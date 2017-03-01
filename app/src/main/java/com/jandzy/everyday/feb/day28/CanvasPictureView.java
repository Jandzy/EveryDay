package com.jandzy.everyday.feb.day28;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

import com.jandzy.everyday.R;

/**
 * canvas picture
 */

public class CanvasPictureView extends View {

    private Picture mPicture;

    private int maxPagenum = 13;
    private int currentPage = 1;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:

                    if(currentPage<maxPagenum-1){
                        currentPage++;
                        invalidate();
                        handler.sendEmptyMessageDelayed(0,500/maxPagenum);
                    }else{
                        return;
                    }

                    break;
            }
        }
    };

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
//        mPicture.draw(canvas);

//        canvas.translate(100,100);

        //picture转换成picturedrawalbe
//        PictureDrawable pictureDrawable = new PictureDrawable(mPicture);
//        pictureDrawable.setBounds(0,0,mPicture.getWidth(),mPicture.getHeight()/2);
//        pictureDrawable.draw(canvas);

//        canvas.translate(0,200);

        //canvas的drawPicture方法
//        canvas.drawPicture(mPicture,new Rect(0,0,mPicture.getWidth()/2,mPicture.getHeight()));

        //cavas 的 drawBitmap
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.checkmark);

        Rect rect = new Rect(bitmap.getHeight()*currentPage,0,bitmap.getHeight()*(currentPage+1),bitmap.getHeight());
        Rect rect1 = new Rect(0,0,400,400);
        canvas.drawBitmap(bitmap,rect,rect1,null);

    }

    public void start(){
        currentPage = -1;

        if(currentPage<maxPagenum){
            handler.sendEmptyMessageDelayed(0,500/maxPagenum);
        }
    }
}
