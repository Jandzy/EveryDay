package com.jandzy.everyday.mar.day13;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jandzy.everyday.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView toDo = (TextView) findViewById(R.id.tv_do);
        TextView testRunnable = (TextView) findViewById(R.id.tv_test_runnable);

        toDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThreTestad test = new ThreTestad();
                test.setPriority(9);
                test.setName("hahaha");
                test.start();
                new ThreTestad().start();
                new ThreTestad().start();
                new ThreTestad().start();
            }
        });

        testRunnable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyRunnable runnable = new MyRunnable();
                new Thread(runnable).start();
                new Thread(runnable).start();
                new Thread(runnable).start();
                new Thread(runnable).start();
            }
        });
    }
}
