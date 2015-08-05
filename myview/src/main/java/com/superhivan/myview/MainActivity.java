package com.superhivan.myview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private GridView mGv;
    private TextView mTv;
    private boolean mDispaly = true;
    private List<String> mDatas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initEvent();
    }

    private void initData() {
        for (int i = 0; i < 9; i++) {
            mDatas.add("Hello"+i);
        }
    }

    private void initEvent() {
        mTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyAdapter adapter = new MyAdapter();

                mGv.setAdapter(adapter);
                if (mDispaly){
                    mDispaly = false;
                    mGv.setVisibility(View.VISIBLE);
                }else{
                    mDispaly = !mDispaly;
                    mGv.setVisibility(View.GONE);
                }
            }
        });
    }

    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            if (mDatas.size()!=0){
                return mDatas.size();
            }
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return mDatas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            TextView tv = new TextView(MainActivity.this);
            tv.setText(mDatas.get(position));

            return tv;
        }
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        mTv = (TextView) findViewById(R.id.tv4);
        mGv = (GridView) findViewById(R.id.gridView);
    }
}
