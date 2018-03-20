package com.kaixuan.djstudy.other2.simple3;

/**
 *
 */
// 咖啡 大杯，小杯 抽象 加料
public abstract class Coffee {
    protected CoffeeAdditives mAdditives;

    public Coffee(CoffeeAdditives additives){
        this.mAdditives = additives;
    }
    // 生成一杯咖啡
    public abstract void makeCoffee();

}
