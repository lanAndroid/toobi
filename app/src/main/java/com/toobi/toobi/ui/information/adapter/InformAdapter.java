package com.toobi.toobi.ui.information.adapter;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.toobi.toobi.R;
import com.toobi.toobi.utils.entry.InformBean;
import com.toobi.toobi.utils.view.GlideRoundTransform;


import java.util.List;

/**
 * Created by Rampant on 2017/11/3.
 */

public class InformAdapter extends Adapter<ViewHolder> {
    private Context context;
    private List<InformBean.DataBean.RoomListBean> inform;

    public InformAdapter(Context context, List<InformBean.DataBean.RoomListBean> inform) {
        this.context = context;
        this.inform = inform;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyHolder myHolder;
        if (viewType == 1) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inform_item, null);
            //    view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT/3, ViewGroup.LayoutParams.WRAP_CONTENT));
            myHolder = new MyHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inform_item2, null);
            // view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT/3, ViewGroup.LayoutParams.WRAP_CONTENT));
            myHolder = new MyHolder(view);
        }
        return myHolder;
    }

    @Override
    public int getItemViewType(int position) {
        String islock = inform.get(position).getIs_lock();
        if (islock.equals("1")) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MyHolder myHolder = (MyHolder) holder;
        if (myHolder.room_name1 != null && myHolder.room_pic1 != null && myHolder.room_suo != null) {
            Picasso.with(context).load(inform.get(position).getRoom_pic()).placeholder(R.drawable.tb5).into(myHolder.room_pic1);
            myHolder.room_name1.setText(inform.get(position).getRoom_name());
        }
        if (myHolder.room_name2 != null && myHolder.room_pic2 != null) {
            Picasso.with(context).load(inform.get(position).getRoom_pic()).placeholder(R.drawable.tb5).into(myHolder.room_pic2);
            myHolder.room_name2.setText(inform.get(position).getRoom_name());
        }
    }

    @Override
    public int getItemCount() {
        return inform.size();
    }

    class MyHolder extends ViewHolder {
        private ImageView room_pic1;
        private ImageView room_suo;
        private ImageView room_pic2;
        private TextView room_name2;
        private TextView room_name1;

        public MyHolder(View itemView) {
            super(itemView);
            room_pic1 = itemView.findViewById(R.id.room_pic1);
            room_pic2 = itemView.findViewById(R.id.room_pic2);
            room_suo = itemView.findViewById(R.id.room_suo);
            room_name2 = itemView.findViewById(R.id.room_name2);
            room_name1 = itemView.findViewById(R.id.room_name1);
        }
    }
}
