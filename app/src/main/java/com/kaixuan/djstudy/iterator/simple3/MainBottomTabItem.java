package com.kaixuan.djstudy.iterator.simple3;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.kaixuan.djstudy.R;
import com.kaixuan.djstudy.buildermodel.Build;

/**
 * Created by Administrator on 2018/3/18.
 */

public class MainBottomTabItem extends BottomTabItem {

    private Builder builder;
    public MainBottomTabItem(Context mContext ) {
        super(mContext, R.layout.tab_main_bottom_item);
    }

    public MainBottomTabItem(Builder builder) {

        this(builder.mContext );
    }

    /**初始化显示*/
    @Override
    protected void initLayout() {
        TextView tv=findViewById(R.id.tv);
        ImageView iv =findViewById(R.id.iv);

        if(TextUtils.isEmpty(builder.text)){
            tv.setText(builder.text);
        }
        if(TextUtils.isEmpty(builder.resIconId+"")){
            iv.setImageResource(builder.resIconId);
        }
    }

    @Override
    protected void setSelected(boolean selected) {
        TextView tv=findViewById(R.id.tv);
        ImageView iv =findViewById(R.id.iv);

        tv.setSelected(selected);
        iv.setSelected(selected);

    }



    public static class Builder{
        Context mContext;
        String text;
        int resIconId;

        public Builder(Context mContext){
            this.mContext=mContext;
        }
        public Builder text(String text){
            this.text=text;
            return this;
        }

        public Builder resIconId(int resIconId){
            this.resIconId=resIconId;
            return this;
        }

        public MainBottomTabItem create(){
            return new MainBottomTabItem(this);
        }
    }
}
