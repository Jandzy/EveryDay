package com.jandzy.everyday.august.day18;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.jandzy.everyday.R;

/**
 * author：jandzy
 * date：2017/8/18
 * email：******@gmail.com
 * DESC:
 */

public class August18MainActivity extends Activity {

    private MyTextView tvDo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_august18);

        tvDo = (MyTextView) findViewById(R.id.tv_do);

        tvDo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
    }


}
