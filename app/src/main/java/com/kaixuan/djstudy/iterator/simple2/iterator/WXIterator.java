package com.kaixuan.djstudy.iterator.simple2.iterator;

import com.kaixuan.djstudy.iterator.simple2.UserInfo;

/**
 * Created by Administrator on 2018/3/17.
 */

public class WXIterator implements Iterator<UserInfo> {

    UserInfo[] userInfos;
    int index = 0;

    public WXIterator(UserInfo[] userInfos) {
        this.userInfos = userInfos;
    }

    @Override
    public UserInfo next() {
        return userInfos[index++];
    }

    @Override
    public boolean hasNext() {
        return index < userInfos.length;
    }
}
