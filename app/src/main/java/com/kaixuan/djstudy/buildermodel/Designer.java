package com.kaixuan.djstudy.buildermodel;

/**
 * Comment:设计者(指导者)
 *
 * 知道如何设计
 * 对于具体建造者的能力有所了解
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2017/9/19
 */
public class Designer {
    public Room builder(Build build) {
        build.makeFllor();
        build.makeWindow();

        return build.build();
    }
}
