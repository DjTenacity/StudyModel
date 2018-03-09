package com.kaixuan.djstudy.architect.simple2;

import com.kaixuan.djstudy.architect.simple2.IBank;
import com.kaixuan.djstudy.architect.simple2.Man;

import java.lang.reflect.Proxy;

/**
 * Comment:静态代理
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2018/3/8
 */
public class Client {

    public static void main (String[] aaaa){

        Man man =new Man("DJ");
        //
        IBank iBank=
                //返回的 是IBank 的一个实例对象,这个对象是由Java给我们创建的,调用的是jni
                (IBank) Proxy.newProxyInstance(
                IBank.class.getClassLoader(),   //classloader  类的加载器
                new Class<?>[]{IBank.class},    //目标接口,必须接口
                new BankInvocationHandler(man)     //InvocationHandler(关键)
                );

        //当调用这个方法的时候,会来到BankInvocationHandler的invoke方法
        iBank.applyBank();
        iBank.lost();
    }
}
