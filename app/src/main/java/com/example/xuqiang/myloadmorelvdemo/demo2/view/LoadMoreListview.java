package com.example.xuqiang.myloadmorelvdemo.demo2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

import com.example.xuqiang.myloadmorelvdemo.R;

/**
 * ================================================
 * 作    者：marsxq
 * 创建日期：2018/4/8
 * 描    述：
 * ================================================
 */
public class LoadMoreListview extends ListView {
    private View mFooterLayout;// 底部布局
    private boolean isLoading;// 判断是否正在加载中

    public LoadMoreListview(Context context) {
        super(context);
        initView(context);
    }

    public LoadMoreListview(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public LoadMoreListview(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(context);
    }


    private void initView(Context context) {
        mFooterLayout = View.inflate(context, R.layout.footer_layout, null);
        mFooterLayout.findViewById(R.id.footer_container).setVisibility(View.GONE);
        this.addFooterView(mFooterLayout);
    }

    // 处理ScrollView嵌套ListView只显示一行的问题，此处让ListView所占的大小与要求的大小一样大
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }

    /**
     * 加载完成，1.设置标志；2.隐藏footer
     */
    public void loadComplete() {
        if (mFooterLayout == null || !isLoading) {
            return;
        }

        isLoading = false;
        mFooterLayout.findViewById(R.id.footer_container).setVisibility(View.GONE);
    }

    /**
     * 开始加载，1.设置标志；2.显示footer
     */
    public void startLoading() {
        if (mFooterLayout == null || isLoading) {
            return;
        }
        isLoading = true;
        mFooterLayout.findViewById(R.id.footer_container).setVisibility(VISIBLE);
    }

    public boolean isLoading() {
        return isLoading;
    }

}
