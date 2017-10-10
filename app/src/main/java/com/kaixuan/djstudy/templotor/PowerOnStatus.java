package com.kaixuan.djstudy.templotor;

import android.util.Log;

/**
 * Comment:关机状态
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2017/10/11
 */
public class PowerOnStatus implements TvStatus {
    @Override
    public void nextChannel() {
        Log.w("TvControl", "下一个频道");
    }

    @Override
    public void preChannel() {
        Log.w("TvControl", "上一个频道");
    }

    @Override
    public void turnOn() {
        Log.w("TvControl", "无效");
    }

    @Override
    public void turnOff() {
        Log.w("TvControl", "正在关机");
    }
}
