package com.kaixuan.djstudy.decorate.simple1;

import android.util.Log;
import android.widget.Toast;

/**
 * Comment:
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2018/3/4
 */
public class StudentEat implements Eat {
    @Override
    public void eat() {
        Log.w("EAT","与食堂大妈勺子永恒的战争");
    }
}
