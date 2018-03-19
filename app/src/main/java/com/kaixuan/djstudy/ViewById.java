package com.kaixuan.djstudy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


// 上面必须要有两个标识
@Target(ElementType.FIELD)    // Target 放在哪里？哪里可以使用  FIELD 属性 TYPE 类上 METHOD 属性
// 什么时候起作用 ，RUNTIME 运行时（程序运行中）  CLASS 代表的是编译时（打包的时候） SOURCE 编程阶段
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewById {// @interface 代表注解
    int value();
}
