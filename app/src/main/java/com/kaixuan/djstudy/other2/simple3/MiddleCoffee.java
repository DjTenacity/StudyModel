package com.kaixuan.djstudy.other2.simple3;

/**
 *
 */

public class MiddleCoffee extends Coffee{
    public MiddleCoffee(CoffeeAdditives additives) {
        super(additives);
    }

    @Override
    public void makeCoffee() {
        System.out.println("中杯的"+mAdditives+"咖啡");
    }
}
