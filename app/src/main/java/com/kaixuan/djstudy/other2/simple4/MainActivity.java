package com.kaixuan.djstudy.other2.simple4;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 *
 */

public class MainActivity extends AppCompatActivity{
    public TextView tv1;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ButterKnife.bind(this);
        MainActivity$$Binder binder = new MainActivity$$Binder();
        binder.bind(this);
    }
}
