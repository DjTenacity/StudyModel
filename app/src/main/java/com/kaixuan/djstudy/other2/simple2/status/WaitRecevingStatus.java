package com.kaixuan.djstudy.other2.simple2.status;

/**
 *
 */
// 待收货状态的下的操作
public class WaitRecevingStatus implements OrderOperateStatus {
    @Override
    public void pay() {
        System.out.println("不在状态");
    }

    @Override
    public void deliverGoods() {
        System.out.println("不在状态");
    }
}
