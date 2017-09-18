package com.kaixuan.djstudy.simplefactory1;

/**
 * Comment:导出数据
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2017/9/6
 */
public class ExportTextOperator extends ExportOperate {
    @Override
    public ExportFileApi newFileApi() {
        return new ExportTextFile();
    }
//    public void export(String data) {
//        ExportDBFile exportDBFile = new ExportDBFile();
//        exportDBFile.export(data);
//    }
}
/**
 * 使用场景:创建对象
 * 简单工厂:
 * 提供创建对象的功能,不需要关心具体的实现
 * <p>
 * 降低客户端与模块之间的耦合度(最少支持原则)
 */