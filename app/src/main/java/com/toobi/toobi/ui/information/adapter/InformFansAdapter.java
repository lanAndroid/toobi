package com.toobi.toobi.ui.information.adapter;

import android.content.Context;
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
import com.toobi.toobi.utils.entry.fans;
import com.toobi.toobi.utils.entry.userInfo;
import com.toobi.toobi.utils.view.GlideRoundTransform;

import java.util.List;

/**
 * Created by Rampant on 2017/11/3.
 */

public class InformFansAdapter extends Adapter<ViewHolder> {
    private Context context;
    private List<userInfo.DataBean.FansListBean> conver;

    public InformFansAdapter(Context context, List<userInfo.DataBean.FansListBean> conver) {
        this.context = context;
        this.conver = conver;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.conver_follow, parent, false);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MyHolder myHolder = (MyHolder) holder;
        myHolder.friend_name.setText(conver.get(position).getUser_name());
        Picasso.with(context).load(conver.get(position).getAvatar()).resize(100,100).transform(new GlideRoundTransform()).into(myHolder.friend_img);
    }

    @Override
    public int getItemCount() {
        return conver.size();
    }

    class MyHolder extends ViewHolder {
        private TextView friend_name;
        private ImageView friend_img;
        private ImageView friend_smms;

        public MyHolder(View itemView) {
            super(itemView);
            friend_name = itemView.findViewById(R.id.friend_name);
            friend_img = itemView.findViewById(R.id.friend_img);
            friend_smms = itemView.findViewById(R.id.friend_smpp);
        }
    }
}
