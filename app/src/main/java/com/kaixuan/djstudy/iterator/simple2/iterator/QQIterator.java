package com.kaixuan.djstudy.iterator.simple2.iterator;

import com.kaixuan.djstudy.iterator.simple2.UserInfo;

import java.util.List;

/**
 * Created by Administrator on 2018/3/17.
 */

public class QQIterator implements Iterator<UserInfo> {
    List<UserInfo> userInfos;
    int index = 0;

    public QQIterator(List<UserInfo> userInfos) {
        this.userInfos = userInfos;
    }

    @Override
    public UserInfo next() {
        return userInfos.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < userInfos.size();
    }
}
