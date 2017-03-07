package com.jandzy.everyday.mar.day7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jandzy.everyday.R;

import org.joda.time.DateTime;

import java.util.Date;

/**
 * gson 学习
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mar_day7);

        gson = new GsonBuilder()
                .registerTypeAdapter(DateTime.class,new DateTimeSerializer())
                .create();
        Log.e(TAG, "serialize: datetime.now == "+DateTime.now().toString() );
        String json = gson.toJson(DateTime.now());
        Log.e(TAG, "deserialize: ==="+json );
        DateTime date = gson.fromJson(json,DateTime.class);
        Log.e(TAG, "deserialize: dateTime"+date.toString() );
    }

    
}
