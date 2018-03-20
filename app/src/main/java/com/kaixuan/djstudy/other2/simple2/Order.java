package com.kaixuan.djstudy.other2.simple2;


import com.kaixuan.djstudy.other2.simple2.status.ObligationStatus;
import com.kaixuan.djstudy.other2.simple2.status.OrderOperateStatus;
import com.kaixuan.djstudy.other2.simple2.status.PaidStatus;
import com.kaixuan.djstudy.other2.simple2.status.WaitRecevingStatus;

/**
 *
 */

public class Order extends BaseOrder implements OrderOperateStatus {

    public Order(){
        // 默认的状态
        mStatus = new ObligationStatus();
    }

    @Override
    public void pay() {
        mStatus.pay();
        // 状态设置已支付的状态
        setStatus(new PaidStatus());
    }

    @Override
    public void deliverGoods() {
        mStatus.deliverGoods();
        // 代发货的状态
        setStatus(new WaitRecevingStatus());
    }
}
