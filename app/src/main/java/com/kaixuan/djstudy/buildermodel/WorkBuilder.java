package com.kaixuan.djstudy.buildermodel;

/**
 * Comment:具体建造者
 * 持有对房子的引用
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2017/9/19
 */
public class WorkBuilder implements Build {

    Room room=new Room();
    @Override
    public void makeWindow() {
        room.setWindow("窗户");
    }

    @Override
    public void makeFllor() {
        room.setFollor("松木");
    }

    @Override
    public Room build() {
        return room;
    }
}
