package com.kaixuan.djstudy.iterator.simple1;

import java.util.ArrayList;
import java.util.List;

/**
 * QQ的用户存储系统.
 */

public class QQUserSystem {


    //list存储
    private List<UserInfo> userInfos;

    public QQUserSystem() {

        userInfos = new ArrayList<>();
        userInfos.add(new UserInfo("1", "1", "1", "1"));
        userInfos.add(new UserInfo("2", "2", "2", "2"));
        userInfos.add(new UserInfo("3", "3", "3", "3"));

    }

    public List<UserInfo> getUserInfos() {
        return userInfos;
    }
}
