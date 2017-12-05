package com.toobi.toobi.ui.personage.view;

import android.os.Build;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.toobi.toobi.R;
import com.toobi.toobi.base.BaseActivity;
import com.toobi.toobi.ui.personage.adapter.PersontopicAdapter;
import com.toobi.toobi.ui.personage.presenter.PersonPresenter;
import com.toobi.toobi.utils.entry.LoginBean;
import com.toobi.toobi.utils.entry.fans;
import com.toobi.toobi.utils.entry.myRoom;
import com.toobi.toobi.utils.entry.suggest;
import com.toobi.toobi.utils.entry.userInfoUpdate;
import com.toobi.toobi.utils.view.RecycleViewDivider;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class TopicActivity extends BaseActivity implements View.OnClickListener, PersonIView {
    private RecyclerView recyclerView;
    private ImageView finsh;
    private PersontopicAdapter persontopicAdapter;
    private List<myRoom.DataBean> list = new ArrayList<>();
    private String id;
    private PersonPresenter personPresenter;


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void initoperate() {

    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true) //在ui线程执行
    public void onDataSynEvent(LoginBean event) {
        id = event.getData().getUserInfo().getUser_id();
        Toast.makeText(this, id+"", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void initListener() {
        finsh.setOnClickListener(this);
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
        personPresenter = new PersonPresenter(this);
        recyclerView = findViewById(R.id.topic_recycler);
        finsh = findViewById(R.id.topic_finish);
        personPresenter.getmyroom("myRoom/uid/" + id);
        persontopicAdapter = new PersontopicAdapter(this, list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new RecycleViewDivider(this,2,R.color.color_eb));
        recyclerView.setAdapter(persontopicAdapter);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_topic;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.topic_finish:
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
        list.clear();
        list.addAll(loginBean.getData());
        persontopicAdapter.notifyDataSetChanged();
    }

    @Override
    public void fan(fans loginBean) {
    }

    @Override
    public void nothing() {

    }
}
