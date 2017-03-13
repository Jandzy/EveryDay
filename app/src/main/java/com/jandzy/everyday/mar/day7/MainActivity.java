package com.jandzy.everyday.mar.day7;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jandzy.everyday.R;
import com.jandzy.everyday.mar.day11.MyExcusionStrategy;

/**
 * gson 学习
 * @blog www.jandzy.com
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mar_day7);

/*        gson = new GsonBuilder()
                .registerTypeAdapter(DateTime.class,new DateTimeSerializer())
                .create();
        Log.e(TAG, "serialize: datetime.now == "+DateTime.now().toString() );
        String json = gson.toJson(DateTime.now());
        Log.e(TAG, "deserialize: ==="+json );
        DateTime date = gson.fromJson(json,DateTime.class);
        Log.e(TAG, "deserialize: dateTime"+date.toString() );*/


        //gson 序列化有参数的类（Money是不支持的类）
/*        gson = new GsonBuilder()
            .excludeFieldsWithModifiers(Modifier.PRIVATE)
                .excludeFieldsWithoutExposeAnnotation()
            .create();
        Money money = new Money(1,"aaaaa","expose");
        String json1 = gson.toJson(money);
        Log.e("instatnce",json1);
        Money money1 = gson.fromJson("{\"count\":1,\"code\":null}",Money.class);
        Log.e(TAG, "onCreate: "+money1.toString() );
        */

        Money money = new Money(1, "codevalue", "exposevalue", "testvalue");
        FieldAttributes field = null;
        try {
            field = new FieldAttributes(money.getClass().getField("code"));
        } catch (NoSuchFieldException e) {
            Log.e(TAG, "onCreate: "+e.toString() );
            e.printStackTrace();
        }

        gson = new GsonBuilder()
                .setExclusionStrategies(new MyExcusionStrategy(field,
                        int.class))
                .serializeNulls()
                .create();
        String json = gson.toJson(money);
        Log.e(TAG, "onCreate: " + json);
    }

    
}
