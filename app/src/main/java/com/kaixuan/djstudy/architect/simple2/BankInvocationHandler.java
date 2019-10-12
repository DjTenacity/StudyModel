package com.kaixuan.djstudy.architect.simple2;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Comment:银行办理业务 ---动态代理 --- InvocationHandler
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2018/3/8
 */
public class BankInvocationHandler implements InvocationHandler
{

    //被代理的对象
    private Object mObject;

    public BankInvocationHandler(Object mObject) {
        this.mObject = mObject;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        //执行方法,目标接口调用的方法都会来到这里面

        System.out.println("MethodName~~~~~~~~"+method.getName());

        //调用被代理对象的方法
        Object voidObject= method.invoke(mObject,objects);
        System.out.println("MethodName~~~~~~~~22222");

        //MethodName~~~~~~~~applyBank
        //DJ没钱也办卡
        //MethodName~~~~~~~~22222
        //MethodName~~~~~~~~lost
        //DJ卡丢了
        //MethodName~~~~~~~~22222
        return voidObject;
    }
}
