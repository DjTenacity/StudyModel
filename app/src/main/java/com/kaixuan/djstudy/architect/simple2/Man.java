package com.kaixuan.djstudy.architect.simple2;

/**
 * Comment:被代理人的对象   银行办理业务
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2018/3/8
 */
public class Man implements IBank {

    String name;

    public Man(String name) {
        this.name = name;
    }

    @Override
    public void applyBank() {
        System.out.println(name+"没钱也办卡");
    }

    @Override
    public void lost() {
        System.out.println(name+"卡丢了");
    }
}
