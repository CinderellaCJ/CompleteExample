package com.cj.completeexample.activity;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.cj.completeexample.R;
import com.cj.completeexample.utils.Constants;
import com.cj.completeexample.utils.ToastUtil;

public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        Log.d("cj", getClass().getSimpleName());//得到当前界面对应的activity名称
    }

    /**
     * 为子类提供一个权限检查方法
     * @param permissions
     * @return
     */
    public boolean haspermission(String... permissions){
        for (String permission : permissions){
            if (ContextCompat.checkSelfPermission(this,permission) != PackageManager.PERMISSION_GRANTED){
                return  false;
            }
        }
        return  true;
    }

    /**
     * 为子类提供一个权限请求方法
     * @param code
     * @param permissions
     */
    public void requestPermission(int code,String... permissions){
        ActivityCompat.requestPermissions(this,permissions,code);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case Constants.PERMISSION_CALL_PHONE:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    doCallPhone();
                }else {
                    ToastUtil.shortToast(this,"请授权拨打电话权限");
                }
                break;
        }
    }

    public void doCallPhone() {
    }
}
