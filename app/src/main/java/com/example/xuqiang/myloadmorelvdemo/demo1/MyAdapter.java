package com.example.xuqiang.myloadmorelvdemo.demo1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.xuqiang.myloadmorelvdemo.R;

import java.util.List;

/**
 * ================================================
 * 作    者：marsxq
 * 创建日期：2018/4/8
 * 描    述：
 * ================================================
 */
public class MyAdapter extends BaseAdapter {

    private Context context;
    private List<String> lists;

    public MyAdapter(Context context, List<String> lists) {
        this.context = context;
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
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.activity_item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String s = lists.get(position);
        holder.tv.setText(s);
        return convertView;
    }

    private class ViewHolder {
        TextView tv;

        public ViewHolder(View v) {
            tv = (TextView) v.findViewById(R.id.tv);
        }
    }
}
