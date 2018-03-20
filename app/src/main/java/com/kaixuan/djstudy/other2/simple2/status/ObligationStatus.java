package com.kaixuan.djstudy.other2.simple2.status;

/**
 *
 */
// 代付款状态的下的操作
public class ObligationStatus implements OrderOperateStatus {
    @Override
    public void pay() {
        System.out.println("支付成功");
    }

    @Override
    public void deliverGoods() {
        System.out.println("不在状态");
    }
}
