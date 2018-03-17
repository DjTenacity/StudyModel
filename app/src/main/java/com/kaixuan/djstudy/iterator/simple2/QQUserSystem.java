package com.kaixuan.djstudy.iterator.simple2;

import com.kaixuan.djstudy.iterator.simple2.iterator.Iterator;
import com.kaixuan.djstudy.iterator.simple2.iterator.QQIterator;

import java.util.ArrayList;
import java.util.List;

/**
 * QQ的用户存储系统.
 */

public class QQUserSystem implements Aggregate<UserInfo>{


    //list存储
    private List<UserInfo> userInfos;

    public QQUserSystem() {

        userInfos = new ArrayList<>();
        userInfos.add(new UserInfo("1", "1", "1", "1"));
        userInfos.add(new UserInfo("2", "2", "2", "2"));
        userInfos.add(new UserInfo("3", "3", "3", "3"));

    }

    //不会爆漏出来
//    public List<UserInfo> getUserInfos() {
//        return userInfos;
//    }

    @Override
    public Iterator<UserInfo> iterator() {
        return new QQIterator(userInfos);
    }
}
