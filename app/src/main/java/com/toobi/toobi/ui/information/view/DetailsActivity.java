package com.toobi.toobi.ui.information.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chanven.lib.cptr.recyclerview.RecyclerAdapterWithHF;
import com.netease.nim.uikit.NimUIKit;
import com.squareup.picasso.Picasso;
import com.toobi.toobi.R;
import com.toobi.toobi.base.BaseActivity;
import com.toobi.toobi.ui.information.adapter.InformFansAdapter;
import com.toobi.toobi.ui.information.presenter.InformPersenter;
import com.toobi.toobi.utils.entry.InformBean;
import com.toobi.toobi.utils.entry.LoginBean;
import com.toobi.toobi.utils.entry.followbean;
import com.toobi.toobi.utils.entry.intoRoom;
import com.toobi.toobi.utils.entry.takeOff;
import com.toobi.toobi.utils.entry.userInfo;
import com.toobi.toobi.utils.view.GlideRoundTransform;
import com.toobi.toobi.utils.view.RecycleViewDivider;
import com.zhy.autolayout.AutoRelativeLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetailsActivity extends BaseActivity implements View.OnClickListener, InformIView {

    private TextView name;
    private ImageView sex;
    private ImageView img;
    private RecyclerView recyclerView;
    private TextView follow;
    private TextView send;
    private ImageView finish;
    private InformPersenter informPersenter;
    private String user_id;
    private int click_user_id;
    private ImageView details_imgg;
    private List<userInfo.DataBean.FansListBean> fansListBeans = new ArrayList<>();
    private String acctoun;
    private String na;
    private String imgurl;
    private PopupWindow popupWindow;
    private AutoRelativeLayout de_au_ll;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void initoperate() {

    }

    @Override
    protected void initListener() {
        follow.setOnClickListener(this);
        send.setOnClickListener(this);
        finish.setOnClickListener(this);
        img.setOnClickListener(this);
    }

    @Override
    protected void initData() {


        EventBus.getDefault().register(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this,android.R.color.white));
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        Intent intent = getIntent();
        if (intent != null) {
            click_user_id = getIntent().getIntExtra("click", 0);
            acctoun = getIntent().getStringExtra("acctoun");
        }
        details_imgg = findViewById(R.id.details_imgg);
        recyclerView = findViewById(R.id.details_recycler);
        name = findViewById(R.id.details_name);
        de_au_ll = findViewById(R.id.de_au_ll);
        img = findViewById(R.id.details_img);
        sex = findViewById(R.id.details_sex);
        follow = findViewById(R.id.details_follow);
        send = findViewById(R.id.details_send);
        finish = findViewById(R.id.details_finish);

        informPersenter = new InformPersenter(this);

        Toast.makeText(this, acctoun + "号" + click_user_id, Toast.LENGTH_SHORT).show();
        informPersenter.userGet("userInfo/user_id/" + user_id + "/click_user_id/" + click_user_id);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_details;
    }


    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true) //在ui线程执行
    public void onDataSynEvent(LoginBean event) {
        user_id = event.getData().getUserInfo().getUser_id();
        acctoun = getIntent().getStringExtra("acctoun");

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.details_finish:
                finish();
                break;
            case R.id.details_send:
                if (follow.getText().toString().equals("已关注")) {
                    NimUIKit.startP2PSession(this, acctoun, na);
                } else if (follow.getText().toString().equals("关注")) {
                    Toast.makeText(this, "请先关注TA", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.details_follow:
                if (follow.getText().equals("已关注")) {
                    HashMap<String, String> map = new HashMap<>();
                    map.put("mid", user_id);
                    map.put("hid", click_user_id + "");
                    informPersenter.takeGet(map);
                } else if (follow.getText().equals("关注")) {
                    HashMap<String, String> map = new HashMap<>();
                    map.put("mid", user_id);
                    map.put("hid", click_user_id + "");
                    informPersenter.followGet(map);

                }
                break;
            case R.id.details_img:
                View view2 = View.inflate(DetailsActivity.this, R.layout.pop_img, null);
                popupWindow = new PopupWindow(view2, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                ImageView imageView = view2.findViewById(R.id.img_da);
                AutoRelativeLayout img_Auto_ll = view2.findViewById(R.id.img_Auto_ll);
                Picasso.with(DetailsActivity.this).load(imgurl).into(imageView);
                popupWindow.setBackgroundDrawable(new ColorDrawable(0));
                popupWindow.showAtLocation(de_au_ll, Gravity.CENTER, 0, 0);
                img_Auto_ll.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                    }
                });
                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        popupWindow.dismiss();
                    }
                });

                break;
        }
    }

    @Override
    public void Informsucceed(InformBean informBean) {

    }

    @Override
    public void sInformsucceed(InformBean informBean) {

    }

    @Override
    public void xInformsucceed(InformBean informBean) {
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void followsucceed(followbean informBean) {
        follow.setTextColor(R.color.color_hs);
        follow.setText("已关注");
        Toast.makeText(this, informBean.getMsg(), Toast.LENGTH_SHORT).show();

    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void usersucceed(final userInfo informBean) {
        fansListBeans.addAll(informBean.getData().getFansList());
        if (fansListBeans.size() == 0) {
            details_imgg.setVisibility(View.VISIBLE);
        } else if (fansListBeans.size() > 0) {
            details_imgg.setVisibility(View.GONE);
        }
        InformFansAdapter informFansAdapter = new InformFansAdapter(this, fansListBeans);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new RecycleViewDivider(this, 2, R.color.color_eb));
        RecyclerAdapterWithHF wf = new RecyclerAdapterWithHF(informFansAdapter);

        recyclerView.setAdapter(wf);
        wf.setOnItemClickListener(new RecyclerAdapterWithHF.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerAdapterWithHF adapter, RecyclerView.ViewHolder vh, int position) {
                Intent intent = new Intent(DetailsActivity.this, DetailsActivity.class);
                int id = Integer.parseInt(informBean.getData().getFansList().get(position).getUser_id());
                intent.putExtra("click", id);
                intent.putExtra("acctoun", informBean.getData().getFansList().get(position).getWangyi_account());
                startActivity(intent);
            }
        });
        na = informBean.getData().getUserInfo().getName();
        name.setText(informBean.getData().getUserInfo().getName());
        imgurl = informBean.getData().getUserInfo().getAvatar();
        Picasso.with(this).load(informBean.getData().getUserInfo().getAvatar()).resize(200,200).transform(new GlideRoundTransform()).into(img);
        String sx = informBean.getData().getUserInfo().getSex();
        if (sx.equals("1")) {
            Picasso.with(this).load(R.drawable.tb24).into(sex);
        } else if (sx.equals("2")) {
            Picasso.with(this).load(R.drawable.tb25).into(sex);
        }
        String fllow = informBean.getData().getUserInfo().getIs_follow();
        if (fllow.equals("1")) {
            follow.setTextColor(R.color.color_hs);
            follow.setText("已关注");

        } else if (fllow.equals("2")) {
            follow.setTextColor(Color.BLACK);
            follow.setText("关注");
        }
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void intosucceed(intoRoom informBean) {

    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void takesucceed(takeOff informBean) {
        follow.setTextColor(Color.BLACK);
        follow.setText("关注");
        Toast.makeText(this, informBean.getMsg(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void nothing(String nothing) {

    }
}
