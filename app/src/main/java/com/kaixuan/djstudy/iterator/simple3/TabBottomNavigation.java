package com.kaixuan.djstudy.iterator.simple3;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import com.kaixuan.djstudy.iterator.simple3.iterator.TabIterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/18.
 */

public class TabBottomNavigation extends LinearLayout {

    private List<BottomTabItem> bottomTabItems;
    private int mCurrentIndex;

    public TabBottomNavigation(Context context) {
        this(context, null);
    }

    public TabBottomNavigation(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TabBottomNavigation(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setOrientation(HORIZONTAL);
        bottomTabItems = new ArrayList<>();
    }

    public void addTabItem(List<BottomTabItem> items) {
        bottomTabItems.clear();
        bottomTabItems.addAll(items);
        for (int i = 0; i < items.size(); i++) {
            BottomTabItem item = items.get(i);
            View tabView = item.getTabView();
            addView(tabView);

            LinearLayout.LayoutParams params = (LayoutParams) tabView.getLayoutParams();
            params.weight = 1;
            params.gravity = Gravity.CENTER;
            tabView.setLayoutParams(params);

            //设置点击事件
            setItemClickListener(tabView, i);

        }

        //第一个位置为选中
        bottomTabItems.get(0).setSelected(true);
        mCurrentIndex = 0;
    }

    public void addTabItem2(TabIterator<BottomTabItem> itemTabIterator) {
        bottomTabItems.clear();
        //当前位置
        int index = 0;

        while (itemTabIterator.hasNext()) {
            index++;

            BottomTabItem item = itemTabIterator.next();
            View tabView = item.getTabView();
            addView(tabView);

            LinearLayout.LayoutParams params = (LayoutParams) tabView.getLayoutParams();
            params.weight = 1;
            params.gravity = Gravity.CENTER;
            tabView.setLayoutParams(params);

            //设置点击事件
            setItemClickListener(tabView, index);
            bottomTabItems.add(item);

        }

        //第一个位置为选中
        bottomTabItems.get(0).setSelected(true);
        mCurrentIndex = 0;
    }

    //设置监听事件
    private void setItemClickListener(View tabView, final int position) {
        tabView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCurrentIndex != position) {
                    //原来的标位未选中
                    bottomTabItems.get(mCurrentIndex).setSelected(false);
                    //当前为选中
                    mCurrentIndex = position;
                    bottomTabItems.get(mCurrentIndex).setSelected(true);

                    //把点击的位置回调出去


                }
            }
        });
    }
}
