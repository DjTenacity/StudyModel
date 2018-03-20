package com.kaixuan.djstudy.other2.simple1;

/**状态模式*/
public class Client {
    public static void main(String[] args){
        Order order = new Order();
        order.pay();
        order.deliverGoods();
    }
}
