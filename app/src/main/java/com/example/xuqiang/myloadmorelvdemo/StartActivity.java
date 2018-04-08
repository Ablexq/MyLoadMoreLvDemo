package com.example.xuqiang.myloadmorelvdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.xuqiang.myloadmorelvdemo.demo1.MainActivity;
import com.example.xuqiang.myloadmorelvdemo.demo2.MainActivityI;

/**
 * ================================================
 * 作    者：marsxq
 * 创建日期：2018/4/8
 * 描    述：
 * ================================================
 */
public class StartActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn1;
    private Button btn2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_layout);
        btn1 = this.findViewById(R.id.btn1);
        btn2 = this.findViewById(R.id.btn2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                startActivity(new Intent(StartActivity.this,MainActivity.class));
                break;
            case R.id.btn2:
                startActivity(new Intent(StartActivity.this,MainActivityI.class));
                break;
        }
    }
}
