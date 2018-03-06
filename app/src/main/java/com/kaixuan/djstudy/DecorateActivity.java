package com.kaixuan.djstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kaixuan.djstudy.decorate.simple2.WrapRecyclerAdapter;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * 装饰设计模式
 */
public class DecorateActivity extends AppCompatActivity {

    public void ioDecorate(){

        try {
            FileReader fr=new FileReader(("xxx.file"));

            //fr.read();

            BufferedReader bfr =new BufferedReader(fr);
            //包裹了之后添加了readline的方法
           // bfr.readLine();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decorate);

        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        //装饰设计模式
        RecyclerAdapter adapter = new RecyclerAdapter();

        View heard = LayoutInflater.from(this).inflate(R.layout.layout_head_view, rv,false);

        // 如果换成WrapRecyclerView  只需要rv.setAdapter(adapter);
        WrapRecyclerAdapter wrapRecyclerAdapter = new WrapRecyclerAdapter(adapter);
        rv.setAdapter(wrapRecyclerAdapter);

        // 如果换成WrapRecyclerView  只需要rv. addFooterView(heard);
        wrapRecyclerAdapter.addFooterView(heard);
        wrapRecyclerAdapter.addHeardView(heard);

        //不要过度封装
        //业务逻辑能分开就分开
        //底层和中间层能封装就封装


        //装饰模式
        //ContextWrapper
        //ListView的Adapter源码
        //io的输出输入流
    }


    private class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(DecorateActivity.this).inflate(R.layout.item_rv_tv, parent, false));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.tv.setText("装饰设计模式 position" + position);

        }

        @Override
        public int getItemCount() {
            return 50;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            public TextView tv;

            public ViewHolder(View itemView) {
                super(itemView);

                tv = (TextView) findViewById(R.id.rv_tv);
            }
        }

    }

}














