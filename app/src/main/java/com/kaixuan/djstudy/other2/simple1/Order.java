package com.kaixuan.djstudy.other2.simple1;


// 3种状态 第一个版本其实够了，但是第二个版本增加了很多状态
public class Order {
    public final int OBLIGATION = 1;// 代付款
    public final int PAID = 2;// 付款
    public final int WAITRECEIVING = 3;// 待收货
    public final int WAITCOMMENT = 4;// 待评价
    // 订单状态
    public int mStatus = OBLIGATION;
    // 付款
    public void pay(){
        if(mStatus == OBLIGATION) {
            mStatus = PAID;
            System.out.println("付款");
        }else {
            System.out.println("不在状态");
        }
    }
    // 发货
    public void deliverGoods(){
        if(mStatus == PAID) {
            mStatus = WAITRECEIVING;
            System.out.println("发货");
        }else{
            System.out.println("不在状态");
        }
    }
}
