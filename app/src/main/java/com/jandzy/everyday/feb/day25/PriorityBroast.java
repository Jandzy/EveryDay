package com.jandzy.everyday.feb.day25;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 *注意  inner Broadcast receiver must be static ( to be registered through Manifest)
 *     OR
 *    Non-static broadcast receiver must be registered and unregistered inside the Parent class
 */

public class PriorityBroast {

    public static class HighBroast extends BroadcastReceiver{
        private static final String TAG = "HighBroast";
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e(TAG, "onReceive: " );
            Bundle bundle =null;
            setResult(0,TAG,bundle);
        }
    }

    public static class MidBroast extends BroadcastReceiver{
        private static final String TAG = "MidBroast";
        @Override
        public void onReceive(Context context, Intent intent) {
            int code = getResultCode(); // 接受上一个广播传来的数据
            String date = getResultData(); //接受上一个广播传来的数据
            Log.e(TAG, "onReceive: "+code+"========"+date);
            //拦截广播，广播不会继续往下传播

            abortBroadcast();
        }
    }

    public static class LowBroast extends BroadcastReceiver{

        private static final String TAG = "LowBroast";

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e(TAG, "onReceive: ");
        }
    }
}
