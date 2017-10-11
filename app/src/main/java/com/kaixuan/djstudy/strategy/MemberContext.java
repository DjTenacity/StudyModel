package com.kaixuan.djstudy.strategy;

/**
 * Comment:策略模式上下文
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2017/10/11
 */
public class MemberContext {
    private Strategy strategy;

    public MemberContext(Strategy strategy) {
        this.strategy = strategy;
    }
    /**
     * 计算打折之后的价格
     * */
    public double caculetor(double price) {
        return strategy.strategyInterface(price);
    }

}
