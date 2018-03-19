package com.kaixuan.djstudy;

import android.content.res.AssetManager;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射
 */

public class TestReflect {

    public static void main(String[] a) {
        //创建对象,很对系统的类都被系统隐藏了,或者是只有系统可以去new,可以通过反射创建对象

        try {
            // TestBean  bean=   TestBean.class.newInstance();   ---->必须要有无参的构造函数

            //getDeclaredConstructor从所有的构造方法里面查找,,,getConstructor从公共构造方法里面去找
            //获取一个参数为String类型的构造方法
            Constructor constructor = TestBean.class.getDeclaredConstructor(String.class);
            constructor.setAccessible(true);//设置权限
            TestBean bean = (TestBean) constructor.newInstance("wewewew");  //调用构造方法传入的参数 wewewew
            bean.printName();


            AssetManager assetManager = AssetManager.class.newInstance();
            //公用方法,不用权限
            Method method = AssetManager.class.getDeclaredMethod("addAssetPath", String.class); //addAssetPath(String path)

            method.invoke(method, "sdcard/dds");

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


        //调用方法
        TestBean bean = new TestBean("weqweqwedas");
        try {
            Method method = TestBean.class.getDeclaredMethod("printName2");
            method.setAccessible(true);
            method.invoke(bean);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        //获取属性
        TestBean beanField = new TestBean("beanField");

        try {
            Field field = TestBean.class.getDeclaredField("name");
            field.setAccessible(true);
            String name = (String) field.get(beanField);

            System.out.println(name);


            Class    clazz = Class.forName("android.app.ActivityThread");

            Field field1 = clazz.getDeclaredField("sCurrentActivityThread");
            field1.setAccessible(true);
            //sCurrentActivityThread静态的
            Object sCurrentActivityThread = field1.get(null);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
