package com.kaixuan.djstudy.iterator.simple3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kaixuan.djstudy.R;
import com.kaixuan.djstudy.iterator.simple3.iterator.ListTabIterator;

import java.util.ArrayList;
import java.util.List;

public class TabItemActivityActivity extends AppCompatActivity {


    private TabBottomNavigation tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_item_activity);

        tab = (TabBottomNavigation) findViewById(R.id.tab);

        List<BottomTabItem> tabItems=new ArrayList<>();

        tabItems.add(new MainBottomTabItem(this));

        tabItems.add(new MainBottomTabItem.Builder(this).text("1111").resIconId(R.mipmap.ic_launcher).create());

        tabItems.add(new MainBottomTabItem.Builder(this).text("2222").resIconId(R.mipmap.ic_launcher).create());

        tabItems.add(new MainBottomTabItem.Builder(this).text("3333").resIconId(R.mipmap.ic_launcher).create());

        tabItems.add(new MainBottomTabItem.Builder(this).text("4444").resIconId(R.mipmap.ic_launcher).create());

        //tab.addTabItem(tabItems);


        ListTabIterator<MainBottomTabItem> listTabIterator=new ListTabIterator<>();

        tab.addTabItem2(listTabIterator);

    }
}
