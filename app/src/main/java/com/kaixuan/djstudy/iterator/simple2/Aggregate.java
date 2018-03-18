package com.kaixuan.djstudy.iterator.simple2;

import com.kaixuan.djstudy.iterator.simple2.iterator.Iterator;

/**
 * Created by Administrator on 2018/3/17.
 */

public interface Aggregate <T> {
    //Aggregate 离开iterator就不能用
    Iterator<T> iterator();
}
