package com.kaixuan.djstudy.architect.simple1;

/**
 * Comment: 银行办理业务   戴利对学生 --银行卡业务员
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2018/3/8
 */
public class BankWorker implements IBank {
   private IBank bank;

    //持有上下文被代理的话对象
    public BankWorker(IBank bank) {
        this.bank = bank;
    }

    @Override
    public void applyBank() {
        System.out.print(" 接受代理  ");

        bank.applyBank();
        System.out.print(" 办卡就办卡 ");

    }
}
