package com.kaixuan.djstudy.single;

/**
 * Comment:单利2
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2017/9/5
 */
public class InnerClassSingle {

    //内部类模式   比较优雅  现成安全,随用随加载
    // ,只有调用getInstance才会调用InnerClassSingle,
    private InnerClassSingle() {

    }

    private static class SingletonHolder {
        private static final InnerClassSingle instance = new InnerClassSingle();
    }

    public static InnerClassSingle getInstance() {
        return SingletonHolder.instance;
    }

//依然反序列化的时候会造成两次或者多次的实例化
}


//引用父类静态字段会不会初始化  子类?
//不会

//通过自定义对象数组类型 会不会加载该类型?
//Class[](Person.class,Child.class)加载这两个字节码文件到内存?
//不会


//在java里是随用随加载
//原因: new了之后这个类才会被加载,或者为是反射,,,,
//只有这两种,才能把类加载进内存

//public static final int a=0; 在Person类里面,
//那么Person.a会不会加载Person类到内存?
//不会
//因为在声明a的时候,直接在编译成class文件的时候已经在class里面定义好了
//再次引用的时候是class字节码里面的内的信息,编译好了,Person并不会被引用,并不会被加载

