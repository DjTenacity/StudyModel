package com.kaixuan.djstudy.templotor;

import android.util.Log;

/**
 * Comment:遥控器-->不用状态模式
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2017/10/11
 */
public class TvControl {
    /**
     * 开机状态
     */
    public final static int POWER_ON = 1;
    /**
     * 关机状态
     */
    public final static int POWER_OFF = 2;


    private int mStatus = POWER_ON;

    /**
     * 关机方法
     */
    public void powerOff() {
        if (mStatus == POWER_OFF) {
            Log.w("TvControl", "已经关机了啊");
        } else {
            Log.w("TvControl", "关机");

            mStatus = POWER_OFF;
        }
    }

    /**
     * 关机方法
     */
    public void powerOn() {
        if (mStatus == POWER_ON) {
            Log.w("TvControl", "已经开机了");
        } else {
            mStatus = POWER_ON;
            Log.w("TvControl", "开机了");


        }
    }

    /**
     * 下一个频道
     */
    public void nextChannel() {
        if (mStatus == POWER_OFF) {
            Log.w("TvControl", "已经关机了啊无效");
        } else {
            Log.w("TvControl", "下一个频道");

        }
    }

    /**
     * 下一个频道
     */
    public void preChannel() {
        if (mStatus == POWER_OFF) {
            Log.w("POWER_OFF", "已经关机了啊无效");
        } else {
            Log.w("POWER_OFF", "上一个一个频道");
        }
    }

}
