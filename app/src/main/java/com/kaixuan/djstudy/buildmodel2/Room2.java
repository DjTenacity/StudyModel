package com.kaixuan.djstudy.buildmodel2;

/**
 * Comment:
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2017/9/19
 */
public class Room2 {

    private String window;
    private String follor;
    private String cateen;

    /**
     * 隐藏构建过程
     */
    public void apply(WorkBuider2.RoomParams params) {
        window = params.window;
        follor = params.follor;
        cateen = params.cateen;

    }
    public void show(){

    }

    @Override
    public String toString() {
        return "Room2{" +
                "window='" + window + '\'' +
                ", follor='" + follor + '\'' +
                ", cateen='" + cateen + '\'' +
                '}';
    }
}
