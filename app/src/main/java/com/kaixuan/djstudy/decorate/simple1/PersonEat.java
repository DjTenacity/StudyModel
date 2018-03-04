package com.kaixuan.djstudy.decorate.simple1;

import android.util.Log;

/**
 * Comment:
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2018/3/4
 */
public class PersonEat implements Eat {
    @Override
    public void eat() {
        Log.w("EAT","Person  eat");
    }
}
