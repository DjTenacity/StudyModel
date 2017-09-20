package com.kaixuan.djstudy.handler;

/**
 * Comment:
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2017/9/21
 */
public abstract class AbstractRequest {

    private Object object;

    public AbstractRequest(Object object)
    {
        this.object=object;
    }
    /**
     * 具体的内容对象
     * @return
     */
    public Object getContent()
    {
        return object;
    }
    /**
     * 获取请求级别
     */
    public abstract int getRequestLevel();
}
