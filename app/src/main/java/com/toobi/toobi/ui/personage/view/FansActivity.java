package com.toobi.toobi.ui.personage.view;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.netease.nim.uikit.NimUIKit;
import com.toobi.toobi.R;
import com.toobi.toobi.base.BaseActivity;
import com.toobi.toobi.ui.conversation.persenter.ConverPersenter;
import com.toobi.toobi.ui.conversation.view.ConverIView;

import com.toobi.toobi.ui.information.view.DetailsActivity;
import com.toobi.toobi.ui.personage.adapter.PersonFansAdapter;
import com.toobi.toobi.ui.personage.presenter.PersonPresenter;
import com.toobi.toobi.utils.entry.LoginBean;
import com.toobi.toobi.utils.entry.chatRoomList;
import com.toobi.toobi.utils.entry.fans;
import com.toobi.toobi.utils.entry.follow;
import com.toobi.toobi.utils.entry.myRoom;
import com.toobi.toobi.utils.entry.suggest;
import com.toobi.toobi.utils.entry.userInfoUpdate;
import com.toobi.toobi.utils.view.RecycleViewDivider;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FansActivity extends BaseActivity implements PersonIView, View.OnClickListener {

    private RecyclerView fan_fans;
    private List<fans.DataBean.FansListBean> list = new ArrayList<>();
    private PersonPresenter personPresenter;
    private String id;

    private PersonFansAdapter personfansadapter;
    private ImageView fans_finish;

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true) //在ui线程执行
    public void onDataSynEvent(LoginBean event) {
        id = event.getData().getUserInfo().getUser_id();
        Toast.makeText(this, event.getData().getUserInfo().getUser_id(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void initoperate() {

    }

    @Override
    protected void initListener() {
        fans_finish.setOnClickListener(this);
        personfansadapter.setOnclic(new PersonFansAdapter.Onclic() {
            @Override
            public void OnimgClick(View v, int position) {
            }

            @Override
            public void OnItemClick(View v, int position) {
                Intent intent = new Intent(FansActivity.this, DetailsActivity.class);
                intent.putExtra("click", list.get(position).getUid());
                //   Toast.makeText(getActivity(), list.get(position).getUid(), Toast.LENGTH_SHORT).show();
                intent.putExtra("acctoun", list.get(position).getWangyi_account());
                startActivity(intent);
            }
        });

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
        fans_finish = findViewById(R.id.fans_finish);
        fan_fans = findViewById(R.id.fan_fans);


        personPresenter = new PersonPresenter(this);
        Toast.makeText(this, id, Toast.LENGTH_SHORT).show();
        personPresenter.getfans("fansList/user_id/" + id);

        fan_fans.setLayoutManager(new LinearLayoutManager(this));
        fan_fans.addItemDecoration(new RecycleViewDivider(this, 2, R.color.color_eb));
        personfansadapter = new PersonFansAdapter(this, list);
        fan_fans.setAdapter(personfansadapter);
        Log.e("FansFragment_log", list.toString());
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_fans;
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fans_finish:
                finish();
                break;
        }
    }

    @Override
    public void Personsucceed(userInfoUpdate userInfoUpdate) {

    }

    @Override
    public void login(LoginBean loginBean) {

    }

    @Override
    public void suggest(suggest loginBean) {

    }

    @Override
    public void myroom(myRoom loginBean) {

    }

    @Override
    public void fan(fans loginBean) {
        list.clear();
        list.addAll(loginBean.getData().getFansList());
        personfansadapter.notifyDataSetChanged();
        Toast.makeText(this, "list.size():" + list.size() + "", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void nothing() {

    }
}
