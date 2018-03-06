package com.kaixuan.djstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * 装饰设计模式
 */
public class DecorateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decorate);

        RecyclerView rv =(RecyclerView) findViewById(R.id.rv);
        rv.setAdapter(new RecyclerAdapter());
    }


    private class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{


        class ViewHolder extends RecyclerView.ViewHolder{



        }

    }

}
