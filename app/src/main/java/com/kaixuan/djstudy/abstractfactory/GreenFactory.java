package com.kaixuan.djstudy.abstractfactory;

/**
 * Comment:专门创建green的产品
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2017/9/6
 */
public class GreenFactory implements IFactory {
    @Override
    public IApi create() {
        return new GreenApi();
    }
}
