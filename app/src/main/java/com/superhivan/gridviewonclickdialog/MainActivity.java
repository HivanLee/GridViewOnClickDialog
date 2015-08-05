package com.superhivan.gridviewonclickdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {

    private GridView mGv;
    private List<Integer> mDatas = new ArrayList<>();
    private String TAG = "MainActivity";

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (position){
                case 6:
                    alertGridView();
                    break;
                case 7:

                    break;
                case 8:

                    break;

                default:
            }
    }

    /**
     * 弹出部分
     */
    private void alertGridView() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);

        View view = View.inflate(this,R.layout.dialog_gridview_layout,null);
        GridView gridView = (GridView) view.findViewById(R.id.gridview_dialog);

        DialogGridViewAdapter adapter = new DialogGridViewAdapter();

        gridView.setAdapter(adapter);
        dialog.setView(view);
        dialog.show();
    }

    private class DialogGridViewAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView tv = new TextView(MainActivity.this);
            tv.setText("Hello"+position);
            return tv;
        }
    }

    private class GridViewAdapter extends BaseAdapter {

        private TextView mTextView;
        private ViewHolder mHolder;

        @Override
        public int getCount() {

            if (mDatas != null) {
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

            mHolder = new ViewHolder();
            if (convertView == null) {

                convertView = View.inflate(MainActivity.this, R.layout.gridview_layout, null);
                mTextView = (TextView) convertView.findViewById(R.id.textView);

                mHolder.textView = mTextView;
            } else {
                convertView.setTag(mHolder);
            }

            mTextView.setText(position + "");

            return convertView;
        }
    }

    class ViewHolder {
        TextView textView;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initEvent();
    }

    private void initEvent() {
        mGv.setOnItemClickListener(this);
    }


    private void initData() {

        for (int i = 0; i < 15; i++) {
            mDatas.add(R.mipmap.ic_launcher);
        }

        GridViewAdapter adapter = new GridViewAdapter();

        mGv.setAdapter(adapter);
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        mGv = (GridView) findViewById(R.id.gridview);
    }
}
