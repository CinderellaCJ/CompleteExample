package com.cj.completeexample.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cj.completeexample.R;
import com.cj.completeexample.bean.Msg;

import java.util.List;

/**
 * Created by chenjing on 2017/6/23.
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {

    private List<Msg> msgList;

    static class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout layoutLeft;
        LinearLayout layoutRigit;

        public ViewHolder(View itemView) {
            super(itemView);
            layoutLeft = (LinearLayout) itemView.findViewById(R.id.layout_left);
            layoutRigit = (LinearLayout) itemView.findViewById(R.id.layout_right);
        }
    }

    public MsgAdapter(List<Msg> msgList) {
        this.msgList = msgList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Msg msg = msgList.get(position);
        if (msg.getMsgType() == Msg.TYPE_RECEIVER){
            holder.layoutLeft.setVisibility(View.VISIBLE);


        }

    }


    @Override
    public int getItemCount() {
        return 0;
    }
}
