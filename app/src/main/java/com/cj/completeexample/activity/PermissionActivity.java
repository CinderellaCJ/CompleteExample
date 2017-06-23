package com.cj.completeexample.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cj.completeexample.utils.Constants;
import com.cj.completeexample.utils.ToastUtil;

import com.cj.completeexample.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PermissionActivity extends BaseActivity {

    @BindView(R.id.btn_call)
    Button btnCall;
    @BindView(R.id.btn_read)
    Button btnRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_call, R.id.btn_read})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_call:
                callPhone();
                break;
            case R.id.btn_read:
                break;
        }
    }

    private void callPhone() {
      /*  if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) !=
                PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission.CALL_PHONE},1);

        }else {
            doCallPhone();
        }*/

      if (haspermission(android.Manifest.permission.CALL_PHONE)){
          doCallPhone();
      }else {
          requestPermission(Constants.PERMISSION_CALL_PHONE,android.Manifest.permission.CALL_PHONE);
      }
    }

    /**
     * 子类实现具体逻辑
     */
    @Override
    public void doCallPhone(){
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+"13675838312"));
        startActivity(intent);
    }

    /*@Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case 1:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    doCallPhone();
                }else {
                    ToastUtil.shortToast(this,"请授权拨打电话权限");
                }
                break;
        }
    }*/
}
