package com.kaixuan.djstudy.interpretor;

/**
 * Comment:取余
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2017/10/5
 */
public class ModNode extends SymbolNode {
    public ModNode(Node left, Node right) {
        super(left, right);
    }


    @Override
    public int interpret() {
        return left.interpret() % right.interpret();
    }
}
