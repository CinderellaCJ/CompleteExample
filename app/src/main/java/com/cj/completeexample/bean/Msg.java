package com.cj.completeexample.bean;

/**
 * Created by chenjing on 2017/6/23.
 */

public class Msg {
    public static final int TYPE_RECEIVER = 0;
    public static final int TYPE_SEND = 1;
    private String msgContent;
    private int msgType;

    public Msg(String msgContent, int msgType) {
        this.msgContent = msgContent;
        this.msgType = msgType;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }
}
