package com.kaixuan.djstudy.single;

/**
 * Comment:单例3
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2017/9/5
 */
public enum EnumManager {
    //枚举的构造方法只能够私有化
    //在枚举里面就只有一份,反序列化也就只有一份
    SDCardManager(10) {
        @Override
        public EnumManager getSingle() {
            return null;
        }
    },
    HttpManager(1) {
        @Override
        public EnumManager getSingle() {
            return null;
        }
    };


    public SdCardImpl getSingleton() {
        return new SdCardImpl();

    }

    public abstract EnumManager getSingle();

    private EnumManager(int type) {

    }

}
