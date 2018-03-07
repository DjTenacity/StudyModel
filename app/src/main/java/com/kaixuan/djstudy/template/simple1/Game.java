package com.kaixuan.djstudy.template.simple1;

/**
 * Comment:定义算法结构,还可以提供通用实现
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2017/10/5
 */
public abstract class Game {
    abstract void login();

    abstract void startPlay();

    abstract void endPlay();


    public final void play() {
        System.out.println("开始");
        login();
        startPlay();
        endPlay();
        System.out.println("结束");

    }

}
