package com.kaixuan.djstudy.prototype;

/**
 * Comment:
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2017/9/6
 */
public class PersonOrder implements IOrder {
    private String orderName;
    private int orderNum;


    @Override
    public int getOrderNumber() {
        return orderNum;
    }

    @Override
    public void setOrderNumber(int number) {
        orderNum = number;
    }


    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderNum() {
        return orderNum;
    }

    @Override
    public Prototype clonePrototype() {
        PersonOrder personOrder = new PersonOrder();
        personOrder.setOrderNumber(orderNum);
        personOrder.setOrderName(orderName);
        return personOrder;
    }
}
