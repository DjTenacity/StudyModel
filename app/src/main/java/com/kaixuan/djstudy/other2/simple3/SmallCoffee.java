package com.kaixuan.djstudy.other2.simple3;

/**
 *
 */

public class SmallCoffee extends Coffee{
    public SmallCoffee(CoffeeAdditives additives) {
        super(additives);
    }

    @Override
    public void makeCoffee() {
        System.out.println("小杯的"+mAdditives+"咖啡");
    }
}
