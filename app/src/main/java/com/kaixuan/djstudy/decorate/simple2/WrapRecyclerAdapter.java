package com.kaixuan.djstudy.decorate.simple2;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Comment:装饰模式
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2018/3/4
 */
public class WrapRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //原来的RecycleView.Adapter 并不支持头部和顶部的添加
    private final RecyclerView.Adapter mRealAdapter;

    ArrayList<View> mHeaderViews;
    ArrayList<View> mFooterViews;


    public WrapRecyclerAdapter(RecyclerView.Adapter mRealAdapter) {
        this.mRealAdapter = mRealAdapter;

        //适配器往往设置条目监听,会影响的是WrapRecyclerAdapter,这里这样设置 就可以让mRealAdapter也变化-->观察者模式
        mRealAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                notifyDataSetChanged();
            }
        });

        mHeaderViews = new ArrayList<>();
        mFooterViews = new ArrayList<>();

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //如果要想知道是哪个部分,必须要知道position也就是位置,但是目前只有ViewType --->getItemViewType()方法

        //头部返回 头部的ViewHolder
        int numHeaders = getHeaderCount();
        if (viewType < numHeaders) {
            return createHeaderFooterViewHolder(mHeaderViews.get(viewType));
        }

        //mRealAdapter 返回  mRealAdapter的ViewHolder
        final int adjPosition = viewType - numHeaders;
        int adapterCount = 0;
        if (mRealAdapter != null) {
            adapterCount = mRealAdapter.getItemCount();
            if (adjPosition < adapterCount) {
                //直接传position  不兼容 万能适配多布局条目
                return mRealAdapter.onCreateViewHolder(parent, mRealAdapter.getItemViewType(adjPosition));
            }

        }

        //底部返回底部的ViewHolder
        return createFooterFooterViewHolder(mFooterViews.get(adjPosition - adapterCount));
    }

    @Override
    public int getItemViewType(int position) {
        //位置作为ViewType
        return position;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //大多情况下头部和底部是都不需要处理的,只有mRealAdapter是需要处理的
        int numHeaders = getHeaderCount();
        if (position < numHeaders) {
            return;
        }

        final int adjPosition = position - numHeaders;
        int adapterCount = 0;
        if (mRealAdapter != null) {
            adapterCount = mRealAdapter.getItemCount();
            if (adjPosition < adapterCount) {
                mRealAdapter.onBindViewHolder(holder, position);
            }
        }
    }

    @Override
    public int getItemCount() {  //总共返回条目数
        return mRealAdapter.getItemCount() + mHeaderViews.size() + mFooterViews.size();
    }

    private RecyclerView.ViewHolder createHeaderFooterViewHolder(View view) {
        return new RecyclerView.ViewHolder(view) {
        };
    }

    private RecyclerView.ViewHolder createFooterFooterViewHolder(View view) {
        return new RecyclerView.ViewHolder(view) {
        };
    }


    public void addHeardView(View view) {
        if (!mHeaderViews.contains(view)) {
            mHeaderViews.add(view);
            notifyDataSetChanged();
        }

    }

    public void addFooterView(View view) {
        if (!mFooterViews.contains(view)) {
            mFooterViews.add(view);
            notifyDataSetChanged();
        }

    }

    public void removeHeardView(View view) {
        if (mHeaderViews.contains(view)) {
            mHeaderViews.remove(view);
            notifyDataSetChanged();
        }
    }

    public void removeFooterView(View view) {
        if (mFooterViews.contains(view)) {
            mFooterViews.remove(view);
            notifyDataSetChanged();
        }
    }

    private int getHeaderCount() {
        return mHeaderViews.size();
    }

    private int getFooterCount() {
        return mFooterViews.size();
    }
}
