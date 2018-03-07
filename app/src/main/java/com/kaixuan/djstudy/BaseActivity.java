package com.kaixuan.djstudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Comment:
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2018/3/7
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //设置布局
        setContentView(getContenView());

        //写一些公用的,Butterknife,统一管理activity

        //初始化Title
        initTitle();
        //初始化View
        initView();
        //访问数据
        initData();
    }

    protected abstract void initData();

    protected abstract int getContenView();

    protected abstract void initView();

    protected abstract void initTitle();

    //不抽象,可以手动添加
    protected void initData2() {
    }

    public void startActivity(Class<? extends Activity> clazz) {
        Intent intent =new Intent(this,clazz);
        startActivity(intent);
    }
}

//钩子: 模板模式用来控制父类的流程, 插件化开发
