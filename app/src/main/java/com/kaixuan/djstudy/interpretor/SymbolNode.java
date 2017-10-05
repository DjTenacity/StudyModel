package com.kaixuan.djstudy.interpretor;

/**
 * Comment:非终结符
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2017/10/5
 */
public abstract class SymbolNode implements Node {

    protected Node left;
    protected Node right;

    public SymbolNode(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

}
