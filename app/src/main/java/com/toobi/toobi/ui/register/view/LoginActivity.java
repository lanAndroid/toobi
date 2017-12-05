package com.toobi.toobi.ui.register.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.github.ybq.android.spinkit.SpinKitView;
import com.netease.nim.uikit.NimUIKit;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.auth.LoginInfo;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.toobi.toobi.R;
import com.toobi.toobi.app.App;
import com.toobi.toobi.ui.homepage.view.HomePageActivity;
import com.toobi.toobi.ui.register.presenter.registerpreIMpl;
import com.toobi.toobi.utils.UserManage;
import com.toobi.toobi.utils.entry.LoginBean;
import com.toobi.toobi.utils.entry.RegisTwo;
import com.toobi.toobi.utils.entry.backpassword;
import com.toobi.toobi.utils.entry.iphonenumber;
import com.toobi.toobi.utils.entry.personage;
import com.toobi.toobi.utils.entry.photo;
import com.toobi.toobi.utils.entry.register;
import com.zhy.autolayout.AutoLayoutActivity;
import com.zhy.autolayout.AutoRelativeLayout;

import org.greenrobot.eventbus.EventBus;
import org.zackratos.ultimatebar.UltimateBar;

import java.util.HashMap;


public class LoginActivity extends AutoLayoutActivity implements registerIView, View.OnClickListener {


    EditText phone;
    EditText psw;
    ImageView registerBtn;
    TextView register;
    TextView forgetpsw;
    TextView xiyi;
    private SpinKitView spinKitView;
    private PopupWindow popupWindow;
    private AutoRelativeLayout auto_re_ll;
    private ImageView weixin;
    private UltimateBar ultimateBar;
    registerpreIMpl registerpreIMpl;

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        UltimateBar ultimateBar = new UltimateBar(this);
        ultimateBar.setImmersionBar();
        initData();
        initListener();
        initoperate();
    }

    protected void initoperate() {

    }


    protected void initListener() {
        registerBtn.setOnClickListener(this);
        register.setOnClickListener(this);
        forgetpsw.setOnClickListener(this);
        xiyi.setOnClickListener(this);
        weixin.setOnClickListener(this);
        psw.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                EditText _v = (EditText) v;
                if (!hasFocus) {// 失去焦点
                    _v.setHint(_v.getTag().toString());
                } else {

                    String hint = _v.getHint().toString();
                    _v.setTag(hint);
                    _v.setHint("");
                }
            }
        });

    }

    protected void initData() {
        weixin = findViewById(R.id.register_Weixin);
        auto_re_ll = findViewById(R.id.auto_re_ll);
        xiyi = findViewById(R.id.xieyi);
        phone = findViewById(R.id.phone);
        registerBtn = findViewById(R.id.login);
        register = findViewById(R.id.register);
        forgetpsw = findViewById(R.id.findpsw);
        psw = findViewById(R.id.psw);
        registerpreIMpl = new registerpreIMpl(this);
    }


    @Override
    public void Regissucceed(iphonenumber iphonenumber) {
        Toast.makeText(this, iphonenumber.getMsg(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void RegisTwosucceed(RegisTwo regisTwo) {

    }

    @Override
    public void backposswordsucceed(backpassword backpassword) {

    }

    @Override
    public void loginsucceed(final LoginBean loginBean) {
        popupWindow.dismiss();
        UserManage.getInstance().saveUserInfo(LoginActivity.this, phone.getText().toString(), loginBean.getData().getUserInfo().getUser_id(), psw.getText().toString(), null, null);
        EventBus.getDefault().postSticky(loginBean);
        EventBus.getDefault().postSticky(new personage(phone.getText().toString(), psw.getText().toString()));
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
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
    private static boolean isExit = false;
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };
    private void exit() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            finish();
            System.exit(0);
        }
    }
    @Override
    public void registersucceed(register register) {

    }

    //  失败方法
    @Override
    public void nothing(String nothing) {
        popupWindow.dismiss();
        Toast.makeText(this, "用户名或密码不正确", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                String phonenumber = phone.getText().toString().trim();
                String pw = psw.getText().toString().trim();
                if (phonenumber.equals("")) {
                    Toast.makeText(this, "用户名密码不能为空", Toast.LENGTH_SHORT).show();
                } else if (pw.equals("")) {
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                } else if (!phonenumber.equals("") && !pw.equals("")) {
                    View v_found = LayoutInflater.from(this).inflate(R.layout.pop_login, null);
                    popupWindow = new PopupWindow(v_found, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                    popupWindow.showAtLocation(auto_re_ll, Gravity.CENTER, 0, 0);
                    HashMap<String, String> map = new HashMap<>();
                    map.put("phone", phonenumber);
                    map.put("password", pw);
                    registerpreIMpl.getLoginPost(map);
                }

                break;
            case R.id.register:
                Intent intent = new Intent(this, RegisTActivity.class);
                startActivity(intent);
                break;
            case R.id.findpsw:
                Intent RegisTgo = new Intent(this, ForgetActivity.class);
                startActivity(RegisTgo);
                break;
            case R.id.xieyi:
                Intent XieYi = new Intent(this, XieYiActivity.class);
                startActivity(XieYi);
                break;
            case R.id.register_Weixin:
                if (!App.iwxapi.isWXAppInstalled()) {
                    Toast.makeText(this, "您还未安装微信客户端", Toast.LENGTH_SHORT).show();
                    return;
                }
                final SendAuth.Req req = new SendAuth.Req();
                req.scope = "snsapi_userinfo";
                req.state = "diandi_wx_login";
                App.iwxapi.sendReq(req);
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                    }
                }, 1000);

                break;
        }
    }

}
