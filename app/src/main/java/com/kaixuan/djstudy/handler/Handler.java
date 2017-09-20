package com.kaixuan.djstudy.handler;

/**
 * Comment:
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2017/9/21
 */
public abstract class Handler {

    public Handler nextHandler;

    public void handleRequest(AbstractRequest abstractRequest) {
        if (getHandleLevel() == abstractRequest.getRequestLevel()) {
            handle(abstractRequest);
        } else {
            if (nextHandler != null) {
                nextHandler.handleRequest(abstractRequest);
            } else {
                System.out.print("所有处理对象都不能处理它");
            }
        }
    }

    /**
     * 每个处理者的对象的具体处理方式
     */
    public abstract void handle(AbstractRequest abstractRequest);

    /**
     * 每个对象处理的级别
     */
    public abstract int getHandleLevel();
}
