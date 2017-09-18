package com.kaixuan.djstudy.abstractfactory;

/**
 * Comment:
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2017/9/6
 */
public class BlueFactory implements IFactory {
    @Override
    public IApi create() {
        return new BlueApi();
    }
}
