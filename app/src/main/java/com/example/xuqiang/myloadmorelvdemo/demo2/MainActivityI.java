package com.example.xuqiang.myloadmorelvdemo.demo2;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.xuqiang.myloadmorelvdemo.R;
import com.example.xuqiang.myloadmorelvdemo.demo2.adapter.CommentListViewAdapter;
import com.example.xuqiang.myloadmorelvdemo.demo2.view.LoadMoreListview;
import com.example.xuqiang.myloadmorelvdemo.demo2.view.PageListScrollView;

import java.util.ArrayList;

/**
 * ================================================
 * 作    者：marsxq
 * 创建日期：2018/4/8
 * 描    述：scrollview 嵌套 listview 上拉加载更多
 * 参考：https://github.com/ganshenml/ImbeddedScrollListViewApp
 * ================================================
 */
public class MainActivityI extends AppCompatActivity implements PageListScrollView.OnScrollToBottomListener {
    private PageListScrollView scrollView;
    private LoadMoreListview listView;
    private CommentListViewAdapter commentListViewAdapter;
    private ArrayList<CommentEntity> commentEntityList;
    private int pagesize = 10;
    private int currentpage = 0;
    private boolean judgeCanLoadMore = true;
    private int totalCount = 50;//设置本次加载的数据的总数


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);


        scrollView = (PageListScrollView) findViewById(R.id.scrollView1);
        scrollView.setOnScrollToBottomListener(this);
        listView = (LoadMoreListview) findViewById(R.id.commentLv);
        listView.setFocusable(false);

        initData();
    }

    private void initData() {
        initAdapter(getCommentList());
    }

    private void initAdapter(ArrayList<CommentEntity> dataList) {
        if (commentListViewAdapter == null) {
            if (commentEntityList == null) {
                commentEntityList = new ArrayList<>();
            }
            commentEntityList.addAll(dataList);
            commentListViewAdapter = new CommentListViewAdapter(this, commentEntityList);
            listView.setAdapter(commentListViewAdapter);
            return;
        }

        if (dataList == null || dataList.size() == 0) {
            return;
        }
        commentEntityList.addAll(dataList);
        if (commentListViewAdapter != null) {
            commentListViewAdapter.notifyDataSetChanged();
        }
    }

    private void initLoadMoreTagOp() {
        if (totalCount == 0 || totalCount <= currentpage * pagesize) {//当前获取的数目大于等于总共的数目时表示数据加载完毕，禁止滑动
            judgeCanLoadMore = false;
            listView.loadComplete();
            return;
        }
    }


    //当ScrollView滑动至底部后，会回调此方法
    @Override
    public void onScrollBottomListener(boolean isBottom) {
        //模拟进行数据的分页加载
        if (judgeCanLoadMore && isBottom && !listView.isLoading()) {
            listView.startLoading();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    initAdapter(getCommentList());
                    listView.loadComplete();
                    initLoadMoreTagOp();
                }
            }, 2000);//模拟网络请求，延缓2秒钟
        }
    }


    /**
     * 模拟网络请求后返回的数据
     *
     * @return
     */
    private ArrayList<CommentEntity> getCommentList() {
        int currentpageCount = currentpage * pagesize;
        if (currentpageCount >= totalCount) {
            return null;
        }
        ArrayList<CommentEntity> list = new ArrayList<>();
        for (int i = currentpageCount + 1; i <= pagesize + currentpageCount; i++) {
            CommentEntity commentEntity = new CommentEntity(i + "",
                    i + "位",
                    "",
                    "这是内容" + i,
                    "2017年7月12日19:20",
                    "2017年7月12日19:20");
            list.add(commentEntity);
        }
        currentpage++;
        return list;
    }
}