package com.kaixuan.djstudy.decorate.simple1;

import android.util.Log;

/**
 * Comment:
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2018/3/4
 */
public class TeacherEat implements Eat {

    Eat eat;
    public TeacherEat(PersonEat personEat) {
        this.eat=personEat;
    }

    @Override
    public void eat() {
        Log.w("EAT","吃好喝好大家好");
        eat.eat();
    }
}
