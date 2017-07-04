package com.cj.completeexample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.cj.completeexample.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.btn_open)
    Button btnOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_open)
    public void onViewClicked() {
        startActivity(new Intent(MainActivity.this,HttpActivity.class));
    }
}
