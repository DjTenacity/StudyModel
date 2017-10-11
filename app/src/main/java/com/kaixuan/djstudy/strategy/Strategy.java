package com.kaixuan.djstudy.strategy;

/**
 * Comment:抽象策略角色
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2017/9/22
 */
public interface Strategy {

    /**调用层
     * 传进的原价
     * 返回打折后的价格
     * */
    public double strategyInterface(double bookPrice);

}
