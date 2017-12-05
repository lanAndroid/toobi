package com.toobi.toobi.ui.information.view;


import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chanven.lib.cptr.PtrClassicFrameLayout;
import com.chanven.lib.cptr.recyclerview.RecyclerAdapterWithHF;
import com.netease.nim.uikit.NimUIKit;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.squareup.picasso.Picasso;
import com.toobi.toobi.R;
import com.toobi.toobi.base.BaseFragment;
import com.toobi.toobi.ui.information.adapter.Inform2Adapter;
import com.toobi.toobi.ui.information.adapter.InformAdapter;
import com.toobi.toobi.ui.information.presenter.InformPersenter;
import com.toobi.toobi.utils.entry.InformBean;
import com.toobi.toobi.utils.entry.LoginBean;
import com.toobi.toobi.utils.entry.follow;
import com.toobi.toobi.utils.entry.followbean;
import com.toobi.toobi.utils.entry.intoRoom;
import com.toobi.toobi.utils.entry.roomSearch;
import com.toobi.toobi.utils.entry.takeOff;
import com.toobi.toobi.utils.entry.userInfo;

import com.toobi.toobi.utils.view.DividerGridItemDecoration;
import com.toobi.toobi.utils.view.GlideRoundTransform;
import com.toobi.toobi.utils.view.GridDivider;
import com.toobi.toobi.utils.view.RecycleViewDivider;
import com.zhy.autolayout.AutoRelativeLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by Rampant on 2017/11/3.
 */

public class InformFragment extends BaseFragment implements InformIView {
    private RecyclerView recyclerView;
    private List<InformBean.DataBean.RoomListBean> list = new ArrayList<>();
    private List<roomSearch.DataBean> roomlist = new ArrayList<>();
    private InformPersenter informPersenter;
    private RecyclerAdapterWithHF hf;
    private AutoRelativeLayout auto_ll;
    private String wangyi_account;
    private String user_id;
    private String hid;
    private String accton;
    private TextView is_follow;
    private RecyclerAdapterWithHF hsf;
    private ImageView inform_img;
    private String roomname;
    private String fid;
    private RefreshLayout refreshLayout;
    private String firstid;
    private String Endid;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IntentFilter intentFilter = new IntentFilter("TOOBI_CREATE");
        getActivity().registerReceiver(broadcastReceiver, intentFilter);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void initPrepare() {

    }

    @Override
    protected void onInvisible() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getActivity().unregisterReceiver(broadcastReceiver);
        EventBus.getDefault().unregister(this);
    }


    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true) //在ui线程执行
    public void onDataSynEvent(roomSearch event) {
        roomlist.addAll(event.getData());

        if (roomlist.size() == 0) {
            inform_img.setVisibility(View.VISIBLE);
        } else {
            inform_img.setVisibility(View.GONE);
        }

        Inform2Adapter inform2Adapter = new Inform2Adapter(getActivity(), roomlist);
        hsf = new RecyclerAdapterWithHF(inform2Adapter);
        Toast.makeText(getActivity(), "aaaaaaaaaaaaaaa", Toast.LENGTH_SHORT).show();
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recyclerView.setAdapter(hsf);
        hsf.setOnItemClickListener(new RecyclerAdapterWithHF.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerAdapterWithHF adapter, RecyclerView.ViewHolder vh, int position) {
                if (wangyi_account.equals(roomlist.get(position).getWangyi_account())) {
                    Toast.makeText(getActivity(), "自己房间无需进入", Toast.LENGTH_SHORT).show();
                } else {
                    hid = list.get(position).getUser_id();
                    accton = list.get(position).getWangyi_account();
                    fid = list.get(position).getFid();
                    roomname = list.get(position).getRoom_name();
                    HashMap<String, String> map = new HashMap<>();
                    map.put("fid", roomlist.get(position).getFid() + "");
                    map.put("user_id", user_id);
                    map.put("room_user_id", roomlist.get(position).getUser_id());
                    map.put("room_name", roomlist.get(position).getRoom_name());
                    Log.e("map-->", map.toString());
                    informPersenter.intoGet(map);
                }
            }
        });
    }


    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true) //在ui线程执行
    public void onDataSynEvent(LoginBean event) {
        wangyi_account = event.getData().getUserInfo().getWangyi_account();
        user_id = event.getData().getUserInfo().getUser_id();
    }

    @Override
    protected void initData() {

        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                //    informPersenter.InformGet("roomList/type/3/id/0");
                informPersenter.xInformGet("roomList/type/1/id/" + firstid);

                if (roomlist.size() != 0) {
                    InformAdapter informAdapter = new InformAdapter(getActivity(), list);
                    hf = new
                            RecyclerAdapterWithHF(informAdapter);
                 //   recyclerView.addItemDecoration(new RecycleViewDivider(getActivity(), 2, R.color.white));
                    recyclerView.setLayoutManager(new
                            GridLayoutManager(getActivity(), 3));
                    recyclerView.setAdapter(hf);
                    roomlist.clear();
                }
                refreshlayout.finishRefresh(1000);
            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                informPersenter.sInformGet("roomList/type/2/id/" + Endid);
                refreshlayout.finishLoadmore(1000);
            }
        });
        informPersenter = new

                InformPersenter(this);
        informPersenter.InformGet("roomList/type/3/id/0");

        InformAdapter informAdapter = new InformAdapter(getActivity(), list);
        hf = new
                RecyclerAdapterWithHF(informAdapter);
        recyclerView.addItemDecoration(new RecycleViewDivider(getActivity(), 2, R.color.white));
        recyclerView.setLayoutManager(new
                GridLayoutManager(getActivity(), 3));
        recyclerView.setAdapter(hf);
        hf.setOnItemClickListener(new RecyclerAdapterWithHF.OnItemClickListener()

        {

            @Override
            public void onItemClick(RecyclerAdapterWithHF adapter, RecyclerView.ViewHolder vh,
                                    int position) {
                Toast.makeText(getActivity(), "" + list.get(position).getWangyi_account(), Toast.LENGTH_SHORT).show();
                if (wangyi_account.equals(list.get(position).getWangyi_account())) {
                    Toast.makeText(getActivity(), "自己房间无需进入", Toast.LENGTH_SHORT).show();
                } else {
                    hid = list.get(position).getUser_id();
                    accton = list.get(position).getWangyi_account();
                    fid = list.get(position).getFid();
                    roomname = list.get(position).getRoom_name();
                    HashMap<String, String> map = new HashMap<>();
                    map.put("fid", list.get(position).getFid());
                    map.put("user_id", user_id);
                    map.put("room_user_id", list.get(position).getUser_id());
                    map.put("room_name", list.get(position).getRoom_name());
                    Log.e("map-->", map.toString());
                    informPersenter.intoGet(map);
                }

            }
        });
    }

    @Override
    protected View initView(LayoutInflater inflater, @Nullable ViewGroup
            container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inform, null);
        inform_img = view.findViewById(R.id.inform_img);
        auto_ll = view.findViewById(R.id.auto_ll_inform);
        refreshLayout = (RefreshLayout) view.findViewById(R.id.refreshLayout);
        recyclerView = view.findViewById(R.id.inform_recycler);
        return view;
    }


    @Override
    public void Informsucceed(InformBean informBean) {
        list.addAll(informBean.getData().getRoomList());
        firstid = informBean.getData().getFirst_id();
        Endid = informBean.getData().getEnd_id();
        hf.notifyDataSetChanged();
    }

    @Override
    public void sInformsucceed(InformBean informBean) {
        if (informBean.getData().getRoomList().size() != 0) {
            list.addAll(informBean.getData().getRoomList());
            hf.notifyDataSetChanged();
            Endid = informBean.getData().getEnd_id();
        } else {
            Toast.makeText(getActivity(), "没有更多数据", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void xInformsucceed(InformBean informBean) {
        if (informBean.getData().getRoomList().size() != 0) {
            list.addAll(0, informBean.getData().getRoomList());
            hf.notifyDataSetChanged();
            firstid = informBean.getData().getFirst_id();
        } else {
            Toast.makeText(getActivity(), "没有更多数据", Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void followsucceed(followbean informBean) {
        is_follow.setTextColor(R.color.color_hs);
        is_follow.setText("已关注");
        Toast.makeText(getActivity(), "informBean.getData():" + informBean.getData(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void usersucceed(userInfo informBean) {

    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void intosucceed(final intoRoom informBean) {
        //    UserManage.getInstance().saveUserInfo(getActivity(), null, null, user_id, null, null);
        //  Toast.makeText(getActivity(), informBean.getData().toString() + "lock", Toast.LENGTH_SHORT).show();
        String islock = informBean.getData().getIs_lock();
        Log.e("----------->", informBean.getData().toString());
        if (islock.equals("0")) {
            NimUIKit.startP2PSession(getActivity(), accton, informBean.getData().getName());
        } else if (islock.equals("1") || islock.equals("2")) {
            View v_found = LayoutInflater.from(getActivity()).inflate(R.layout.pop_you, null);
            final PopupWindow popupWindow = new PopupWindow(v_found, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
            popupWindow.setFocusable(true);
            popupWindow.showAtLocation(auto_ll, Gravity.CENTER, 0, 0);
            AutoRelativeLayout you_aul = v_found.findViewById(R.id.you_aul);
            TextView pop_chat = v_found.findViewById(R.id.pop_chat);
            TextView name = v_found.findViewById(R.id.pop_name);
            ImageView img = v_found.findViewById(R.id.pop_img);
            ImageView sex = v_found.findViewById(R.id.pop_sex);
            TextView sign = v_found.findViewById(R.id.pop_title);
            is_follow = v_found.findViewById(R.id.pop_attention);
            TextView claclen = v_found.findViewById(R.id.pop_clenal);
            name.setText(informBean.getData().getName());
            Picasso.with(getActivity())
                    .load(informBean.getData().getAvatar())
                    .resize(200,200)
                    .transform(new GlideRoundTransform())
                    .into(img);
            if (informBean.getData().getSex().equals("1")) {
                Glide.with(getActivity()).load(R.drawable.tb24).into(sex);
            } else if (informBean.getData().getSex().equals("2")) {
                Glide.with(getActivity()).load(R.drawable.tb25).into(sex);
            }
            sign.setText(informBean.getData().getSign());
            if (informBean.getData().getIs_follow().equals("1")) {
                is_follow.setTextColor(R.color.color_hs);
                is_follow.setText("已关注");
            } else if (informBean.getData().getIs_follow().equals("2")) {
                is_follow.setTextColor(Color.BLACK);
                is_follow.setText("关注");
            }
            pop_chat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NimUIKit.startP2PSession(getActivity(), accton, informBean.getData().getName());
                }
            });
            you_aul.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), DetailsActivity.class);
                    int gd = Integer.parseInt(hid);
                    intent.putExtra("click", gd);
                    intent.putExtra("acctoun", accton);
                    startActivity(intent);
                }
            });
            is_follow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (is_follow.getText().equals("已关注")) {
                        HashMap<String, String> map = new HashMap<>();
                        map.put("mid", user_id);
                        map.put("hid", hid);
                        informPersenter.takeGet(map);
                    } else if (is_follow.getText().equals("关注")) {
                        HashMap<String, String> map = new HashMap<>();
                        map.put("mid", user_id);
                        map.put("hid", hid);
                        informPersenter.followGet(map);
                    }
                }
            });
            claclen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    popupWindow.dismiss();
                }
            });
        }
    }


    @SuppressLint("ResourceAsColor")
    @Override
    public void takesucceed(takeOff informBean) {
        is_follow.setTextColor(Color.BLACK);
        is_follow.setText("关注");
        hf.notifyDataSetChanged();
        Toast.makeText(getActivity(), informBean.getMsg(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void nothing(String nothing) {

    }

    private  BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("TOOBI_CREATE")) {
                String name = intent.getStringExtra("name");
                String imgurl = intent.getStringExtra("imgurl");
                String roomid = intent.getStringExtra("roomid");
                String first = intent.getStringExtra("first");
                Toast.makeText(context, "guangbo", Toast.LENGTH_SHORT).show();
                list.add(0, new InformBean.DataBean.RoomListBean(roomid, user_id, wangyi_account, "0", name, imgurl));
                Toast.makeText(context, "---------------->", Toast.LENGTH_SHORT).show();
                hf.notifyDataSetChanged();
                if (first != null) {
                    firstid = first;
                }

            }
        }
    };


}
