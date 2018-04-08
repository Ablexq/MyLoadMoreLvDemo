package com.example.xuqiang.myloadmorelvdemo.demo1;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import com.example.xuqiang.myloadmorelvdemo.R;


/**
 * ================================================
 * 作    者：marsxq
 * 创建日期：2018/4/8
 * 描    述：
 * ================================================
 */
public class LoadMoreListView extends ListView implements AbsListView.OnScrollListener {
    private View mFooterLayout;
    private int mTotalItemCount;
    private int mLastItemCount;
    private boolean isLoading;
    private LoadMoreListener loadMoreListener;

    public LoadMoreListView(Context context) {
        super(context);
        initView(context);
    }

    public LoadMoreListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public LoadMoreListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        mFooterLayout = View.inflate(context, R.layout.footer_layout, null);
        mFooterLayout.findViewById(R.id.footer_container).setVisibility(View.GONE);
        addFooterView(mFooterLayout);
        this.setOnScrollListener(this);
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        this.mTotalItemCount = totalItemCount;
        this.mLastItemCount = firstVisibleItem + visibleItemCount;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (mTotalItemCount == mLastItemCount && scrollState == SCROLL_STATE_IDLE) {
            if (!isLoading) {
                isLoading = true;
                mFooterLayout.findViewById(R.id.footer_container).setVisibility(View.VISIBLE);
                loadMoreListener.loadmore();
            }
        }
    }

    public void loadMoreComplete() {
        if (isLoading) {
            isLoading = false;
            mFooterLayout.findViewById(R.id.footer_container).setVisibility(View.GONE);
        }
    }

    public void setLoadmoreListener(LoadMoreListener loadmoreListener) {
        this.loadMoreListener = loadmoreListener;
    }

    public interface LoadMoreListener {
        void loadmore();
    }
}