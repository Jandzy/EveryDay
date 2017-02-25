package com.jandzy.everyday.feb.day25;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.TextView;

import com.jandzy.everyday.R;

/**
 * android 广播
 *
 * http://blog.csdn.net/qq_30379689/article/details/53341313
 */

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day25_activity_main);

        ((TextView) findViewById(R.id.tv_sendBorast)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendBroadcast(new Intent("com.jandzy.broadcast"));
            }
        });

         findViewById(R.id.tv_orderBorast).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 sendOrderedBroadcast(new Intent("com.jandzy.broadcast1"),null);
             }
         });

        findViewById(R.id.tv_sendResultBroast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //这样 即使广播被拦截，最终 LowBroast仍然能接收到
                sendOrderedBroadcast(new Intent("com.jandzy.broadcast1"),null,
                        new PriorityBroast.LowBroast(),new Handler(),
                        0,null,null);
            }
        });

        findViewById(R.id.tv_sendLocaBroast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //本地广播 只能发送给自己应用内的信息广播
                LocalBroadcastManager.getInstance(MainActivity.this).sendBroadcast(
                        new Intent("com.jandzy.broadcast")
                );
            }
        });

    }
}
