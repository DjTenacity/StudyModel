package com.kaixuan.djstudy.iterator.simple2;

import com.kaixuan.djstudy.iterator.simple2.iterator.Iterator;
import com.kaixuan.djstudy.iterator.simple2.iterator.WXIterator;

/**
 * WX的用户存储系统.
 */

public class WXUserSystem implements Aggregate<UserInfo> {

   public UserInfo[] userInfos;

   public WXUserSystem(){
       userInfos=new UserInfo[3];
       userInfos[0]= new UserInfo("WX1", "1WX", "1WX", "1WX") ;
       userInfos[1]= new UserInfo("WXWX2", "2WX", "2WX", "2WX") ;
       userInfos[2]= new UserInfo("WXWXWX3", "3WX", "3WX", "3WX") ;
   }

    @Override
    public Iterator<UserInfo> iterator() {
        return new WXIterator(userInfos);
    }
}
