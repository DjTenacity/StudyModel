package com.kaixuan.djstudy.template.simple2;

import android.support.annotation.NonNull;

/**
 * Comment:
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2018/3/7
 */
public class Request implements Runnable,Comparable<Request> {


    @Override
    public void run() {
                System.out.print("下载图片等耗时操作 完毕"+Thread.currentThread().getName());

    }


    @Override
    public int compareTo(@NonNull Request request) {
        return 0;
    }
}
