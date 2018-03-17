package com.kaixuan.djstudy.iterator.simple1;

/**
 * 一般写法,没有使用迭代器模式
 */

public class Client {
    public static void main(String[] a) {

        //根据用户名和密码去查询用户信息
        //如果没有查询到那么代表登录失败,反之则为登陆成功
        UserInfo loginUserInfo = queryWXUserInfo("4", "4");

        if (loginUserInfo == null) {
            loginUserInfo = queryQQUserInfo("4", "4");
        }
        //如果有了新浪微博登录   又要写,,,,扩展性不足
        if(loginUserInfo==null){
            //登录失败
        }
    }

    private static UserInfo queryWXUserInfo(String s, String s1) {
        WXUserSystem wxUserSystem=new WXUserSystem();
        UserInfo[] userInfos=wxUserSystem.getUserInfos();
        for (UserInfo userInfo:userInfos ) {
            if( s.equals(userInfo.userName) && s1.equals(userInfo.userPwd)){
                return userInfo;
            }
        }
        return null;
    }

    private static UserInfo queryQQUserInfo(String s, String s1) {
        QQUserSystem qqUserSystem=new QQUserSystem();
        for (UserInfo userInfo:qqUserSystem.getUserInfos() ) {
            if( s.equals(userInfo.userName) && s1.equals(userInfo.userPwd)){
                return userInfo;
            }
        }
        return null;
    }
}
