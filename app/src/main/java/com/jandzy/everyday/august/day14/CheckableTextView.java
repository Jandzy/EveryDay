package com.jandzy.everyday.august.day14;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.Checkable;

/**
 * Created by jandzy on 2017/8/16.
 */

public class CheckableTextView extends AppCompatTextView implements Checkable {

    public CheckableTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CheckableTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void setChecked(boolean checked) {
        if(checked){
            setBackgroundColor(Color.RED);
        }else{
            setBackgroundColor(Color.GREEN);
        }
    }

    @Override
    public boolean isChecked() {
        return false;
    }

    @Override
    public void toggle() {

    }
}
