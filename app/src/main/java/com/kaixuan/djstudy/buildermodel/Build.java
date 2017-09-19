package com.kaixuan.djstudy.buildermodel;

/**
 * Comment:  抽象建造者----定义具体建造者如何建造
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2017/9/19
 */
public interface Build {
    // 建造者模式:将一个复杂的构建于它的表示分离,是的同样的构建过程可以创建不同的表示

    public void makeWindow();

    public void makeFllor();

    public Room build();

}
