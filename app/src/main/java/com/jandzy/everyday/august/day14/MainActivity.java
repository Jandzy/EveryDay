package com.jandzy.everyday.august.day14;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.inputmethodservice.InputMethodService;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.jandzy.everyday.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * android 键盘学习总结
 */

public class MainActivity extends Activity {
    InputMethodService inputMethodService;
    BroadcastReceiver broadcastReceiver;
    ContentProvider contentProvider;
    Service service;
    Application application;


    private ListView lvLeft, lvRight;
    private List<String> lefts, rights;

    private LeftAdapter leftAdapter, rightAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.august_activity_main);

        lvLeft = (ListView) findViewById(R.id.lv_left);
        lvRight = (ListView) findViewById(R.id.lv_right);

        initData();

        leftAdapter = new LeftAdapter(lefts);
        rightAdapter = new LeftAdapter(rights);

        lvLeft.setAdapter(leftAdapter);
        lvRight.setAdapter(rightAdapter);


        lvLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                lvLeft.post(new Runnable() {
                    @Override
                    public void run() {
                        lvLeft.smoothScrollToPositionFromTop(position, 0);
                        int point = 0;
                        for (int i = 0; i < rights.size(); i++) {
                            if (TextUtils.equals(lefts.get(position), rights.get(i))) {
                                point = i;
                                break;
                            }
                        }
                        Log.e("xxx", "run: " + point);
                        lvRight.smoothScrollToPositionFromTop(point, 0);
                    }
                });
            }
        });

        lvRight.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                for (int i = 0; i < lefts.size(); i++) {
                    if (TextUtils.equals(lefts.get(i), rights.get(firstVisibleItem))) {
//                        lvLeft.setSelection(i);
//                        lvLeft.smoothScrollToPosition(i);
//                        lvLeft.requestFocus(i);

                        lvLeft.smoothScrollToPositionFromTop(i, 0);
                        lvLeft.setItemChecked(i, true);
                    }

                }
            }
        });
    }

    private void initData() {
        lefts = new ArrayList<>();
        rights = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            lefts.add(i + "");
            Random random = new Random();

            int j = Math.abs(random.nextInt(20));
            int k = j == 0 ? 1 : j;
            for (int b = 0; b < k; b++) {
                rights.add(i + "");
            }
        }
    }


    class LeftAdapter extends BaseAdapter {

        private List<String> lists;

        public LeftAdapter(List<String> lists) {
            this.lists = lists;
        }

        @Override
        public int getCount() {
            return lists.size();
        }

        @Override
        public Object getItem(int position) {
            return lists.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_main, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.text = (CheckableTextView) convertView.findViewById(R.id.text);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.text.setText(lists.get(position));

            return convertView;
        }

    }

    class ViewHolder {
        private CheckableTextView text;
    }
}
