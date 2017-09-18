package com.kaixuan.djstudy.single;

/**
 * Comment: 单例模式
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2017/9/5
 */
public class Singleton {
    //饿汗式   多线程安全, 一加载这个class字节码,就把当前的单例模式加载进来了但是违背了java的随用随加载
    //public static Singleton singleton = new Singleton();

    private volatile static Singleton instance;

    //懒汉式   实现了随用随加载,线程安全,但是效率不高,因为每次加载都要进行一个同步操作,性能上是有差异的
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    private Singleton() {

    }

    //private  static Singleton instance;

    //DCL单例模式, 双层检查 并不是那么安全,高并发可以出现问题
    public static Singleton getDCLInstance() {

        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }


}
//类在编译的时候是编译成为class字节码
//jvm在遇到有main函数的会去开辟一个jvm引擎实例,开辟进城实例去专门加载这个字节码
//来到main方法中就会在内存中开辟一段空间来作为方法区,还有一个java栈
//字节码文件加载方法区中遇到了main函数,会把main函数信息压到java栈里面
//java执行的函数都是在里虚拟机执行的,而虚拟机是在内存里面执行的
//main方法是在java栈里面(指令集)执行的


//main方法里面

//Singleton singleto  =  Singleton.getInstance();
//这一句可以拆分成两部分:
//Singleton singleto;  会将Singleton.class的字节 码加载到方法区,会在方法区的常量池定义一个singleto的符号变量
//这个符号变量就指向了内存中为这个这个字节码开辟的空间,
//class字节码在内存中只有一份(对象可以有多个),

//Singleton.getInstance();

/**
 * 换句话说
 * 第一步: 提取含有main函数的类的字节码文件放入方法区,在常量池有一个Singleton的符号引用,()这个引用并没有指向真正类信息的地址
 * <p>
 * 第二步:运行到Singleton singleto 将Singleton的字节码信息加载到内存
 * 这时Singleton的符号变量指向class类信息
 * ,指向
 * 第三步:声明singleto 变量,还没有实例化,指向Singleton的内存空间
 * <p>
 * 第四步:在堆区开辟空间,实例化对象
 * <p>
 * 很容易出现jvm指令集乱序的问题(第四步在第三步前面),volatile可以解决,同步java指令集
 * <p>
 * jvm指令集乱序容易出现是JDK1.5以后支持了多并发指令集,所以会出现指令集乱序
 * <p>
 * 入栈,栈帧是线程私有的,成员变量是安全的
 */