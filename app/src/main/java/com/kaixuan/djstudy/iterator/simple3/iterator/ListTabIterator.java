package com.kaixuan.djstudy.iterator.simple3.iterator;

import com.kaixuan.djstudy.iterator.simple3.BottomTabItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/18.
 */

public class ListTabIterator<T extends BottomTabItem> implements TabIterator {

    private List<T> tabItems;
    private int index;

    public ListTabIterator( ) {
         tabItems = new ArrayList<>();
    }
    public void addItem(T item){
        tabItems.add(item);
    }

    @Override
    public T next() {
        return tabItems.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < tabItems.size();
    }
}
