package com.kaixuan.djstudy.iterator.simple2;

import com.kaixuan.djstudy.iterator.simple2.iterator.Iterator;

/**
 * Created by Administrator on 2018/3/17.
 */

public interface Aggregate <T> {

    Iterator<T> iterator();
}
