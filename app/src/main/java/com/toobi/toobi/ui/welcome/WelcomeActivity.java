package com.toobi.toobi.ui.welcome;

import android.content.Intent;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.netease.nim.uikit.NimUIKit;
import com.toobi.toobi.utils.UserManage;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.auth.LoginInfo;
import com.toobi.toobi.R;
import com.toobi.toobi.base.BaseActivity;
import com.toobi.toobi.ui.homepage.view.HomePageActivity;
import com.toobi.toobi.ui.register.presenter.registerpreIMpl;
import com.toobi.toobi.ui.register.view.RegisterActivity;
import com.toobi.toobi.ui.register.view.registerIView;
import com.toobi.toobi.utils.entry.LoginBean;
import com.toobi.toobi.utils.entry.RegisTwo;
import com.toobi.toobi.utils.entry.Userofo;
import com.toobi.toobi.utils.entry.backpassword;
import com.toobi.toobi.utils.entry.iphonenumber;
import com.toobi.toobi.utils.entry.photo;
import com.toobi.toobi.utils.entry.register;
import com.toobi.toobi.wxapi.presenter.wxpreIMpl;
import com.toobi.toobi.wxapi.wxIview;
import com.toobi.toobi.wxapi.wxdata;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class WelcomeActivity extends BaseActivity implements Animation.AnimationListener, registerIView, wxIview {

    private static final int CODE_FOR_WRITE_PERMISSION = 0;
    registerpreIMpl registerpreIMpl;
    ImageView welcomeHello;
    private String name;
    private String psw;
    private String token;
    private String openid;
    wxpreIMpl wxpreIMpl;

    @Override
    protected void initoperate() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

        welcomeHello = findViewById(R.id.welcome_hello);
        AlphaAnimation alpha = new AlphaAnimation(3F, 0F);
        alpha.setDuration(2000);
        alpha.setFillAfter(true);
        welcomeHello.setAnimation(alpha);
        alpha.setAnimationListener(this);
        registerpreIMpl = new registerpreIMpl(this);
        wxpreIMpl = new wxpreIMpl(this);
        Userofo userInfo = UserManage.getInstance().getUserInfo(this);
        name = userInfo.getUserName();
        psw = userInfo.getPassword();
        token = userInfo.getToken();
        openid = userInfo.getOpenid();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (name.equals("") && psw.equals("") && token.equals("") && openid.equals("")) {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
            finish();
        } else if (!name.equals("") && !psw.equals("")) {
            HashMap<String, String> map = new HashMap<>();
            map.put("phone", name);
            map.put("password", psw);
            registerpreIMpl.getLoginPost(map);
        } else if (!token.equals("") && !openid.equals("")) {
            getWXUserInfo(token, openid);
        } else {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
            finish();
        }
    }


    @Override
    public void onAnimationRepeat(Animation animation) {

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

    /**
     * 获取微信登录，用户授权后的个人信息
     *
     * @param access_token
     * @param openid
     */
    private void getWXUserInfo(final String access_token, final String openid) {
        String path = "https://api.weixin.qq.com/sns/userinfo?access_token="
                + access_token
                + "&openid="
                + openid;
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().get().url(path).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                wxdata wxdata = gson.fromJson(response.body().string(), com.toobi.toobi.wxapi.wxdata.class);
                HashMap<String, String> map = new HashMap<>();
                map.put("openid", openid);
                map.put("userName", wxdata.getNickname());
                map.put("avatar", wxdata.getHeadimgurl());
                wxpreIMpl.getLoginPost(map);

            }
        });

    }

    @Override
    public void loginsucceed(LoginBean loginBean) {
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
    public void sunccess(LoginBean loginBean) {
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
    public void nothing() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
        finish();
    }
}
