package com.kaixuan.djstudy;

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
}
