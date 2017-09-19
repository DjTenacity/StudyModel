package com.kaixuan.djstudy.buildermodel;

/**
 * Comment:
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2017/9/19
 */
public class Room {

    private String window;
    private String follor;

    public String getWindow() {
        return window;
    }

    public void setWindow(String window) {
        this.window = window;
    }

    public String getFollor() {
        return follor;
    }

    public void setFollor(String follor) {
        this.follor = follor;
    }

    @Override
    public String toString() {
        return "Room{" +
                "window='" + window + '\'' +
                ", follor='" + follor + '\'' +
                '}';
    }
}
