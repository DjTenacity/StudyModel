package com.kaixuan.djstudy.prototype;

/**
 * Comment:产品
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2017/9/6
 */
public interface IOrder extends Prototype{

    int getOrderNumber();


    void setOrderNumber(int number);
}
/**
 * 概念：原型模式属于创建型模式
 * 用原型的实例指定创建对象的种类，并通过拷贝这些原型创建新的对象
 * <p>
 * 通俗的意思：复制一个一模一样的对象出来：
 * 目的 保护最原始的那一份存档。隐藏复制过程。
 */