package com.kaixuan.djstudy.template.simple1;

import com.kaixuan.djstudy.template.simple1.Game;

/**
 * Comment:
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2017/10/5
 */
public class LoLGame extends Game {
    @Override
    void login() {
        System.out.println("开始 login");

    }

    @Override
    void startPlay() {
        System.out.println("开始游戏");

    }

    @Override
    void endPlay() {
        System.out.println("结束游戏");

    }
}
