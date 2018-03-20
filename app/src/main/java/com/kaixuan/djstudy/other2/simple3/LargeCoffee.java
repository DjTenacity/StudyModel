package com.kaixuan.djstudy.other2.simple3;

/**
 *
 */

public class LargeCoffee extends Coffee{
    public LargeCoffee(CoffeeAdditives additives) {
        super(additives);
    }

    @Override
    public void makeCoffee() {
        System.out.println("大杯的"+mAdditives+"咖啡");
    }
}
