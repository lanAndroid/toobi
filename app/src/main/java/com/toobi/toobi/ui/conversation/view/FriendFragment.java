package com.toobi.toobi.ui.conversation.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.chanven.lib.cptr.recyclerview.RecyclerAdapterWithHF;
import com.netease.nim.uikit.NimUIKit;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.toobi.toobi.R;
import com.toobi.toobi.base.BaseFragment;
import com.toobi.toobi.ui.conversation.persenter.ConverPersenter;
import com.toobi.toobi.ui.conversation.view.ConverIView;
import com.toobi.toobi.ui.conversation.view.adapter.ConverFriendAdapter;
import com.toobi.toobi.ui.information.adapter.InformAdapter;
import com.toobi.toobi.ui.information.view.DetailsActivity;
import com.toobi.toobi.utils.entry.LoginBean;
import com.toobi.toobi.utils.entry.chatRoomList;
import com.toobi.toobi.utils.entry.fans;
import com.toobi.toobi.utils.entry.follow;
import com.toobi.toobi.utils.view.DividerGridItemDecoration;
import com.toobi.toobi.utils.view.RecycleViewDivider;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Rampant on 2017/11/6.
 */

public class FriendFragment extends BaseFragment implements ConverIView {
    private RecyclerView recyclerView;
    private List<follow.DataBean.FollowListBean> list = new ArrayList<>();
    private ConverPersenter converPersenter;
    private ImageView friend_img;
    private String id;
    private ConverFriendAdapter friendAdapter;
    private SmartRefreshLayout refreshLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void initPrepare() {

    }

    @Override
    protected void onInvisible() {

    }


    @Override
    protected void initData() {

        if (list.size() < 0) {
            friend_img.setVisibility(View.VISIBLE);
        } else if (list.size() > 0) {
            friend_img.setVisibility(View.GONE);
        }

        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                //    informPersenter.InformGet("roomList/type/3/id/0");
                converPersenter.getfollow("followList/user_id/" + id);
                refreshlayout.finishRefresh(1000);
            }
        });
        converPersenter = new ConverPersenter(this);
        converPersenter.getfollow("followList/user_id/" + id);
        friendAdapter = new ConverFriendAdapter(getActivity(), list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new RecycleViewDivider(getActivity(), 2, R.color.color_eb));
        recyclerView.setAdapter(friendAdapter);
        friendAdapter.setOnclic(new ConverFriendAdapter.Onclic() {

            @Override
            public void OnItemClick(View v, int position) {
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra("click", list.get(position).getUid());
                intent.putExtra("acctoun", list.get(position).getWangyi_account());
                startActivity(intent);
            }
        });
    }

    @Override
    protected View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.friend, null);
        friend_img = view.findViewById(R.id.img_friend);
        recyclerView = view.findViewById(R.id.friend_recycler);
        refreshLayout = view.findViewById(R.id.con_refreshLayout);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true) //在ui线程执行
    public void onDataSynEvent(LoginBean event) {
        id = event.getData().getUserInfo().getUser_id();
        Toast.makeText(getActivity(), event.getData().getUserInfo().getUser_id(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getsuccend(follow follow) {
        list.clear();
        list.addAll(follow.getData().getFollowList());
        friendAdapter.notifyDataSetChanged();
    }

    @Override
    public void getfanssuccend(fans fans) {

    }

    @Override
    public void getchatsuccend(chatRoomList fans) {

    }

}
