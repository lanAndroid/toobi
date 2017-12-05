package com.toobi.toobi.ui.personage.view;

import android.media.Image;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.toobi.toobi.R;
import com.toobi.toobi.base.BaseActivity;
import com.toobi.toobi.ui.personage.presenter.PersonPresenter;
import com.toobi.toobi.utils.entry.LoginBean;
import com.toobi.toobi.utils.entry.fans;
import com.toobi.toobi.utils.entry.myRoom;
import com.toobi.toobi.utils.entry.suggest;
import com.toobi.toobi.utils.entry.userInfoUpdate;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;

public class FeedbackActivity extends BaseActivity implements View.OnClickListener, PersonIView {
    private ImageView finsh;
    private ImageView btn;
    private EditText edt;
    private PersonPresenter personPresenter;
    private String id;
    private String name;

    @Override
    protected void initoperate() {

    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true) //在ui线程执行
    public void onDataSynEvent(LoginBean event) {
        id = event.getData().getUserInfo().getUser_id();
        name = event.getData().getUserInfo().getName();

    }

    @Override
    protected void initListener() {
        btn.setOnClickListener(this);
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
        finsh = findViewById(R.id.feedback_finish);
        btn = findViewById(R.id.feedback_btn);
        edt = findViewById(R.id.feedback_edt);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_feedback;
    }

    @Override
    public void onClick(View view) {
        String content = edt.getText().toString().trim();
        switch (view.getId()) {
            case R.id.feedback_finish:
                finish();
                break;
            case R.id.feedback_btn:

                HashMap<String, String> map = new HashMap<>();
                map.put("user_id", id);
                map.put("user_name", name);
                map.put("content", content);
                personPresenter.getsuggest(map);
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
        Toast.makeText(this, loginBean.getMsg(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void myroom(myRoom loginBean) {

    }

    @Override
    public void fan(fans loginBean) {

    }

    @Override
    public void nothing() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
