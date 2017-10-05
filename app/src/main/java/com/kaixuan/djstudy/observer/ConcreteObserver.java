package com.kaixuan.djstudy.observer;

/**
 * Comment:具体观察者
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2017/10/5
 */
public class ConcreteObserver implements Observer {

    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String content) {
        System.out.print(name + "收到消息" + content);
    }
}
