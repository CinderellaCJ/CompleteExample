package com.cj.completeexample.widget;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;

import com.cj.completeexample.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by chenjing on 2017/6/23.
 */

public class TitleLayout extends LinearLayout {
    @BindView(R.id.btn_back)
    Button btnBack;

    public TitleLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.custom_title, this);
    }

    @OnClick(R.id.btn_back)
    public void onViewClicked() {
        ((Activity)getContext()).finish();
    }
}
