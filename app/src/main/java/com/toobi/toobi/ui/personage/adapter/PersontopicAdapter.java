package com.toobi.toobi.ui.personage.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.toobi.toobi.R;
import com.toobi.toobi.utils.entry.fans;
import com.toobi.toobi.utils.entry.myRoom;
import com.toobi.toobi.utils.view.GlideRoundTransform;

import java.util.List;

/**
 * Created by Rampant on 2017/11/3.
 */

public class PersontopicAdapter extends Adapter<ViewHolder> {
    private Context context;
    private List<myRoom.DataBean> conver;

    public PersontopicAdapter(Context context, List<myRoom.DataBean> conver) {
        this.context = context;
        this.conver = conver;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_topic, parent, false);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        MyHolder myHolder = (MyHolder) holder;
        myHolder.friend_name.setText("“" + conver.get(position).getRoom_name() + "”");
        myHolder.friend_number.setText(conver.get(position).getNum()+"人参与");
    }

    private Onclic Onclic;

    public void setOnclic(Onclic onclic) {
        this.Onclic = onclic;
    }

    public interface Onclic {
        void OnimgClick(View v, int position);

        void OnItemClick(View v, int position);
    }

    @Override
    public int getItemCount() {
        return conver.size();
    }

    class MyHolder extends ViewHolder {
        private TextView friend_name;
        private TextView friend_number;

        public MyHolder(View itemView) {
            super(itemView);
            friend_name = itemView.findViewById(R.id.friend_name);
            friend_number = itemView.findViewById(R.id.friend_number);
        }
    }
}
