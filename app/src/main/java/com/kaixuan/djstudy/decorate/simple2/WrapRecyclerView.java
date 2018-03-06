package com.kaixuan.djstudy.decorate.simple2;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Comment: 六大基本原则之最少知道原则之后的优化
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2018/3/6
 */
public class WrapRecyclerView extends RecyclerView {

    WrapRecyclerAdapter mAdapter;

    public WrapRecyclerView(Context context) {
        this(context,null);
    }

    public WrapRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public WrapRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    @Override
    public void setAdapter(Adapter adapter) {
        mAdapter = new WrapRecyclerAdapter(adapter);

        super.setAdapter(mAdapter);
    }

    public void addHeardView(View view) {
        if (mAdapter!=null) {
            mAdapter.addHeardView(view);
        }
    }

    public void addFooterView(View view) {
        //必须要先设置adapter
        if (mAdapter!=null) {
            mAdapter.addFooterView(view);
        }
    }

    public void removeHeardView(View view) {
        if (mAdapter!=null) {
            mAdapter.removeHeardView(view);
        }
    }

    public void removeFooterView(View view) {
        if (mAdapter!=null) {
            mAdapter.removeFooterView(view);
        }
    }

}
