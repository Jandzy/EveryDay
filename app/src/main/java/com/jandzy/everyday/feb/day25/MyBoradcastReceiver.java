package com.jandzy.everyday.feb.day25;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/2/25 0025.
 */

public class MyBoradcastReceiver extends BroadcastReceiver {

    private static final String TAG = "MyBoradcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG, "onReceive: " );
        Toast.makeText(context, "onReceive"+intent.getAction(), Toast.LENGTH_SHORT).show();
    }
}
