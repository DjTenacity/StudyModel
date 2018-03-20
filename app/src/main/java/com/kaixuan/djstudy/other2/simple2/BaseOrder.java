package com.kaixuan.djstudy.other2.simple2;


import com.kaixuan.djstudy.other2.simple2.status.OrderOperateStatus;

/**
 *
 */

public class BaseOrder {
    protected OrderOperateStatus mStatus;

    public void setStatus(OrderOperateStatus status){
        this.mStatus = status;
    }
}
