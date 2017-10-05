package com.kaixuan.djstudy.interpretor;

/**
 * Comment:终结符,不能被分解,
 * 语法树
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2017/10/5
 */
public class ValueNode implements Node {

    private int value;

    public ValueNode(int value) {
        this.value = value;
    }

    @Override
    public int interpret() {
        return value;
    }
}
