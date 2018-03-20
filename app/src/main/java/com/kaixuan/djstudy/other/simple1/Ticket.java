package com.kaixuan.djstudy.other.simple1;

import java.util.Random;

/**
 * Created by Administrator on 2018/3/20.
 */

public class Ticket {
    private String from, to;

    public Ticket(String from, String to) {
        this.from = from;
        this.to = to;


    }

    int getPrice() {
        return new Random().nextInt(50) + 40;
    }
}
