package com.toobi.toobi.ui.personage.view;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.netease.nim.uikit.NimUIKit;
import com.toobi.toobi.utils.UserManage;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.auth.LoginInfo;
import com.squareup.picasso.Picasso;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.toobi.toobi.R;
import com.toobi.toobi.app.App;
import com.toobi.toobi.base.BaseActivity;
import com.toobi.toobi.ui.homepage.view.HomePageActivity;
import com.toobi.toobi.ui.register.presenter.registerpreIMpl;
import com.toobi.toobi.ui.register.view.ForgetActivity;
import com.toobi.toobi.ui.register.view.RegisTActivity;
import com.toobi.toobi.ui.register.view.XieYiActivity;
import com.toobi.toobi.ui.register.view.registerIView;
import com.toobi.toobi.utils.entry.LoginBean;
import com.toobi.toobi.utils.entry.RegisTwo;
import com.toobi.toobi.utils.entry.Userofo;
import com.toobi.toobi.utils.entry.backpassword;
import com.toobi.toobi.utils.entry.iphonenumber;
import com.toobi.toobi.utils.entry.photo;
import com.toobi.toobi.utils.entry.register;
import com.toobi.toobi.utils.view.GlideRoundTransform;
import com.zhy.autolayout.AutoRelativeLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;

public class QuitActivity extends BaseActivity implements registerIView, View.OnClickListener {

    private ImageView img;
    private ImageView login;
    private EditText psw;
    private TextView wangji;
    private TextView zhuce;
    private TextView xieyi;
    private ImageView Weixin;
    private AutoRelativeLayout autoll;
    private registerpreIMpl registerpreIMpl;
    private String imgurl;
    private String phone;
    private PopupWindow popupWindow;

    @Override
    protected void initoperate() {

    }

    @Override
    protected void initListener() {
        login.setOnClickListener(this);
        xieyi.setOnClickListener(this);
        Weixin.setOnClickListener(this);
        zhuce.setOnClickListener(this);
        wangji.setOnClickListener(this);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        EventBus.getDefault().register(this);
    }


    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true) //在ui线程执行
    public void onDataSynEvent(LoginBean event) {
        imgurl = event.getData().getUserInfo().getAvatar();
        Toast.makeText(this, event.getData().getUserInfo().getUser_id(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void initData() {
        String imgurl = getIntent().getStringExtra("img");
        img = findViewById(R.id.quit_img);
        Weixin = findViewById(R.id.quit_Weixin);
        autoll = findViewById(R.id.quit_ll);
        xieyi = findViewById(R.id.quit_xieyi);
        login = findViewById(R.id.quit_login);
        zhuce = findViewById(R.id.quit_zhuce);
        wangji = findViewById(R.id.quit_zhaohui);
        psw = findViewById(R.id.quit_psw);
        Toast.makeText(this, "imgurl" + imgurl, Toast.LENGTH_SHORT).show();
        Picasso.with(this)
                .load(imgurl).transform(new GlideRoundTransform())
                .placeholder(R.drawable.tb5)
                .into(img);
        Userofo userInfo = UserManage.getInstance().getUserInfo(this);
        phone = userInfo.getUserName();
        registerpreIMpl = new registerpreIMpl(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_quit;
    }

    @Override
    public void Regissucceed(iphonenumber iphonenumber) {

    }

    @Override
    public void RegisTwosucceed(RegisTwo regisTwo) {

    }

    @Override
    public void backposswordsucceed(backpassword backpassword) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.quit_login:
                String pw = psw.getText().toString().trim();
                if (pw.equals("")) {
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                } else if (!pw.equals("")) {
                    View v_found = LayoutInflater.from(this).inflate(R.layout.pop_login, null);
                    popupWindow = new PopupWindow(v_found, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                    popupWindow.showAtLocation(autoll, Gravity.CENTER, 0, 0);
                    HashMap<String, String> map = new HashMap<>();
                    map.put("phone", phone);
                    map.put("password", pw);
                    registerpreIMpl.getLoginPost(map);
                }

                break;
            case R.id.quit_zhuce:
                Intent intent = new Intent(this, RegisTActivity.class);
                startActivity(intent);
                break;
            case R.id.quit_zhaohui:
                Intent RegisTgo = new Intent(this, ForgetActivity.class);
                startActivity(RegisTgo);
                break;
            case R.id.quit_xieyi:
                Intent XieYi = new Intent(this, XieYiActivity.class);
                startActivity(XieYi);
                break;
            case R.id.quit_Weixin:
                if (!App.iwxapi.isWXAppInstalled()) {
                    Toast.makeText(this, "您还未安装微信客户端", Toast.LENGTH_SHORT).show();
                    return;
                }
                final SendAuth.Req req = new SendAuth.Req();
                req.scope = "snsapi_userinfo";
                req.state = "diandi_wx_login";
                App.iwxapi.sendReq(req);
                break;
        }
    }

    @Override
    public void loginsucceed(LoginBean loginBean) {
        popupWindow.dismiss();
        UserManage.getInstance().saveUserInfo(QuitActivity.this, phone, loginBean.getData().getUserInfo().getUser_id(), psw.getText().toString(), null, null);
        EventBus.getDefault().postSticky(loginBean);
        LoginInfo loginInfo = new LoginInfo(loginBean.getData().getUserInfo().getWangyi_account(), loginBean.getData().getUserInfo().getWangyi_token(), loginBean.getData().getUserInfo().getWangyi_appkey());

        NimUIKit.login(loginInfo, new RequestCallback<LoginInfo>() {
            @Override
            public void onSuccess(LoginInfo loginInfo) {
                Log.d("MainActivity----------", "成功");
                //   Toast.makeText(RegisterActivity.this, "成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailed(int i) {

            }

            @Override
            public void onException(Throwable throwable) {
            }
        });

        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void photosucceed(photo photo) {

    }

    @Override
    public void registersucceed(register register) {

    }

    @Override
    public void nothing(String nothing) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
