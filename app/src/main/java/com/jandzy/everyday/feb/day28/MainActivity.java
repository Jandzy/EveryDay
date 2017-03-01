package com.jandzy.everyday.feb.day28;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.jandzy.everyday.R;

/**
 * 自定义view的canvas图片学习
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_day28);
        final CanvasPictureView canvasPictureView = (CanvasPictureView) findViewById(R.id.canvas);
        canvasPictureView.start();
        canvasPictureView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                canvasPictureView.start();
            }
        });
    }
}
