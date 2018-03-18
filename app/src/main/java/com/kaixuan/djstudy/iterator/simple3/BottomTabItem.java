package com.kaixuan.djstudy.iterator.simple3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/**
 * 基类
 */

public abstract class BottomTabItem {
    //布局 id  ,Context  ,builder设计模式

    //底部的子条目
    private View mTabItemView;

    private Context mContext;

    private int mLayoutId;

    public BottomTabItem(Context mContext, int mLayoutId) {
        this.mContext = mContext;
        this.mLayoutId = mLayoutId;
    }

    /**
     *获取底部条目
     */
    public View getTabView(){
        if(mTabItemView == null){
            mTabItemView= LayoutInflater.from(mContext).inflate(mLayoutId,null);
            initLayout();
        }
        return mTabItemView;
    }

    /**初始化显示*/
    protected  abstract void initLayout();


    protected <T>T findViewById(int id){
        return (T) mTabItemView.findViewById(id);
    }

    /**
     * 是否选中当前条目
     * */
    protected abstract void setSelected(boolean selected);
}
