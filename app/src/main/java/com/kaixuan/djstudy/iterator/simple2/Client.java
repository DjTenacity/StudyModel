package com.kaixuan.djstudy.iterator.simple2;

import com.kaixuan.djstudy.iterator.simple2.iterator.Iterator;

/**
 * 使用迭代器模式
 * 提供一个种方法顺序访问一个容器中的各个元素,而不需要暴露该对象的内部显示
 */

public class Client {
    public static void main(String[] a) {

        WXUserSystem wxUserSystem =new WXUserSystem();

        //根据用户名和密码去查询用户信息
        //如果没有查询到那么代表登录失败,反之则为登陆成功
        UserInfo loginUserInfo = queryUserInfo("4", "4",wxUserSystem.iterator());

        //这里做了 if else判断,可以用责任链进行优化
        if (loginUserInfo == null) {
            QQUserSystem qqUserSystem =new QQUserSystem();
            loginUserInfo = queryUserInfo("4", "4",qqUserSystem.iterator());
        }

    }


    private static UserInfo queryUserInfo(String s, String s1, Iterator<UserInfo> iterator) {
        while (iterator.hasNext()){
            UserInfo userInfo=iterator.next();
            if(s.equals(userInfo.userName) && s1.equals(userInfo.userPwd)){
                return userInfo;
            }
        }
        return null;
    }
}
