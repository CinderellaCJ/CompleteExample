package com.cj.completeexample.interf;

/**
 * Created by chenjing on 2017/7/3.
 */

public interface HttpCallBackListener {
    void onFinish(String response);
    void onError(Exception e);
}
