package com.kaixuan.djstudy.strategy;

/**
 * Comment:高级会员
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2017/10/11
 */
public class Strategy1 implements Strategy {


    @Override
    public double strategyInterface(double bookPrice) {
        //返回打折后的价格
        return bookPrice * 0.8;
    }
}
