package com.jandzy.everyday.mar.day13;

import android.util.Log;

/**
 * Created by Administrator on 2017/3/13 0013.
 */

public class ThreTestad extends Thread{

    private static final String TAG = "ThreTestad";

    private int count = 10;

    @Override
    public void run() {
        while (count>0){
            Log.e(TAG, Thread.currentThread().getName()+"       " +count--);
        }
    }
}
