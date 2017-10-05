package com.kaixuan.djstudy.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Comment:抽象的被观察者
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2017/10/5
 */
public class AbstractSubject {

    //保存着所有观察者对象
    private List<Observer> list = new ArrayList<>();


    public void attach(Observer observer) {
        list.add(observer);
    }

    public void detach(Observer observer) {
        if (observer != null && list.size() > 0 && list.contains(observer)) {
            list.remove(observer);
        }
    }

    public void notify(String content) {
        for (Observer observer : list) {
            //最先注册的最先通知
            observer.update(content);
        }

    }

}
