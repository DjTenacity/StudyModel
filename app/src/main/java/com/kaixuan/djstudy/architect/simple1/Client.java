package com.kaixuan.djstudy.architect.simple1;

/**
 * Comment:静态代理
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2018/3/8
 */
public class Client {

    public static void main (String[] aaaa){

        Man man =new Man( );
        BankWorker bankWorker=new BankWorker(man);
        bankWorker.applyBank();
    }
}
