package com.kaixuan.djstudy.simplefactory2;

/**
 * Comment:
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2017/9/6
 */
public class Factory {

    public static Api create(int type) {
        switch (type) {
            case 1:
                return new ImplA();
            case 2:
                return new ImplB();
            default:
                return new ImplA();

        }
    }

    public <T extends Api> T creatProduce(Class<T> clz) {
        Api api = null;

        try {
            api = (Api) Class.forName(clz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return (T) api;
    }

}
