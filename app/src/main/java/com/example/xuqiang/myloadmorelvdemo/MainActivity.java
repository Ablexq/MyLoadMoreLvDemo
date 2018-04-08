package com.example.xuqiang.myloadmorelvdemo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoadMoreListView.LoadMoreListener {
    private List<String> mlist;
    private LoadMoreListView loadMoreListView;
    private MyAdapter mMyadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadMoreListView = findViewById(R.id.loadMoreListView);
        loadMoreListView.setLoadmoreListener(this);

        initData();
        mMyadapter = new MyAdapter(this, mlist);
        loadMoreListView.setAdapter(mMyadapter);
    }

    private void initData() {
        mlist = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mlist.add("我是初始的" + i + "界面");
        }
    }

    private void initLoadData() {
        for (int i = 0; i < 5; i++) {
            mlist.add("我是加载更多的" + i + "界面");
        }
    }

    @Override
    public void loadmore() {
        //模拟数据加载延时2秒,增强用户体验,当然开发中不需要使用handler来进行延时操作
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                initLoadData(); //加载更多数据
                mMyadapter.notifyDataSetChanged(); //通知适配器更新
                loadMoreListView.loadMoreComplete();   //加载完数据后设置footerview隐藏
            }
        }, 2000);
    }
}