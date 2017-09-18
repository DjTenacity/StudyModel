package com.kaixuan.djstudy.simplefactory1;

/**
 * Comment:
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2017/9/6
 */
public abstract class ExportOperate {

    /**
     * 实例化ExportFileApi
     */
    public abstract ExportFileApi newFileApi();

    /**
     * 导出数据
     */
    public void export(String data) {
        ExportFileApi fileApi = newFileApi();
        fileApi.export(data);
    }

}
