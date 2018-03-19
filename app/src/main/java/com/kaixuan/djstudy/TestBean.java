package com.kaixuan.djstudy;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by Administrator on 2018/3/19.
 */

public class TestBean {

    private String name="2222";  //属性 String类型  name 变量名称  =====>Filed


    //构造函数
    public TestBean(String name) {
        this.name = name;
    }

    //方法   getName->方法名字 String->返回值类型   =====>method
    public String getName() {
        return name;
    }

    public void printName() {
        System.out.print(name);
    }
    private String getName2() {
        return name;
    }

    private void printName2() {
        System.out.println(name);
    }



    private Object[] items=new Object[10];

    public <T> void add(T t){
        items[0] = t;
    }

    private <T> T reName(String name){
        return  (T)getName2();
    }


    public abstract class HttpCallBack<T> {

        public abstract void onSuccess(T result);
    }


    /**上限
     * public void startActivity(Class<? extends BaseActivity> clazz) {
         Intent intent =new Intent(this,clazz);
         startActivity(intent);
     }

     下限  包括MainActivity和他的父类
     public void startActivity(Class<? super MainActivity> clazz) {
     Intent intent =new Intent(this,clazz);
     startActivity(intent);
     }
     */
}
