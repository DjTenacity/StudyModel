package com.kaixuan.djstudy.templotor;

import android.util.Log;

/**
 * Comment:上下文
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2017/10/11
 */
public class TVStatusControl {
    TvStatus mTvState;

    private void setState(TvStatus mTvState) {
        this.mTvState = mTvState;
    }

    public void powerOn() {
        setState(new PowerOnStatus());
        Log.w("TvControl", "开机la");
        mTvState.turnOn();
    }

    public void powerOff() {
        setState(new PowerOffStatus());
        Log.w("TvControl", "关机la");
        mTvState.turnOff();

    }

    //-----------------------------

    public void nextChannel() {
        mTvState.nextChannel();
    }

    public void preChannel() {
        mTvState.preChannel();
    }

    public void turnOn() {
        mTvState.turnOn();
    }

    public void turnOff() {
        mTvState.turnOff();
    }
}
