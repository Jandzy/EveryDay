package com.jandzy.everyday.mar.day13;

import android.util.Log;

/**
 * Created by Administrator on 2017/3/13 0013.
 */

public class MyRunnable implements Runnable {

    private static final String TAG = "MyRunnable";

    private int count = 1000;

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            synchronized (this) {
                if (count > 0) {
                    Log.e(TAG, Thread.currentThread().getName() + "    " + count--);
                }
            }
        }
    }
}
