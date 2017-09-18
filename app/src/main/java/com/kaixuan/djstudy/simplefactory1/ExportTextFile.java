package com.kaixuan.djstudy.simplefactory1;

/**
 * Comment:导出文本
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2017/9/6
 */
public class ExportTextFile implements ExportFileApi {
    @Override
    public void export(String data) {
        System.out.print("导出文本"+data);
    }
}
