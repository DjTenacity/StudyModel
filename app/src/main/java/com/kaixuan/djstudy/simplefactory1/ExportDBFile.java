package com.kaixuan.djstudy.simplefactory1;

/**
 * Comment:
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2017/9/6
 */
public class ExportDBFile implements ExportFileApi {

    @Override
    public void export(String data) {
        System.out.println("导出数据库文件" + data);
    }
}
