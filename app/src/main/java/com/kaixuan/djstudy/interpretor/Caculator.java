package com.kaixuan.djstudy.interpretor;

/**
 * Comment: 解释器模式之运算
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2017/10/5
 */
public class Caculator {
    public int build(String statement) {
        Node left = null;
        Node right = null;
        Node lastNode = null;

        String[] stateMents = statement.split(" ");
        for (int i = 0; i < stateMents.length; i++) {
            if ("*".equals(stateMents[i])) {
                //计算乘法
                left = lastNode;
                int val = Integer.parseInt(stateMents[++i]);
                right = new ValueNode(val);
                //此时新建了一个非终结符
                lastNode = new MulNode(left, right);

            } else if ("/".equals(stateMents[i])) {
                //计算除法
                left = lastNode;
                int val = Integer.parseInt(stateMents[++i]);
                right = new ValueNode(val);
                //此时新建了一个非终结符
                lastNode = new DivNode(left, right);

            } else {
                lastNode = new ValueNode(Integer.parseInt(stateMents[i]));
            }

        }
        return lastNode.interpret();
    }
}
