package com.kaixuan.djstudy.buildmodel2;

/**
 * Comment:
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2017/9/19
 */
public class WorkBuider2 {

    Room2 room = new Room2();
    private RoomParams params = new RoomParams();

    public WorkBuider2 makeWindow(String window) {
        params.window = window;
        return this;
    }

    public WorkBuider2 makeFllor(String follor) {
        params.follor = follor;
        return this;
    }

    public WorkBuider2 makeCateen(String cateen) {
        params.cateen = cateen;
        return this;
    }
    public void show(){

    }
    /**
     * 真正的构建
     */
    public Room2 build() {
        room.apply(params);
        return room;
    }
  ///AlertController
    class RoomParams {
        public String window;
        public String follor;
        public String cateen;
    }
}
