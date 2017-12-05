package com.toobi.toobi.wxapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.netease.nim.uikit.NimUIKit;
import com.toobi.toobi.utils.UserManage;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.auth.LoginInfo;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.toobi.toobi.app.App;
import com.toobi.toobi.ui.homepage.view.HomePageActivity;
import com.toobi.toobi.utils.entry.LoginBean;
import com.toobi.toobi.wxapi.presenter.wxpreIMpl;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.HashMap;

import io.reactivex.annotations.Nullable;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Rampant on 2017/11/14.
 */

public class WXEntryActivity extends Activity implements IWXAPIEventHandler, wxIview {
    private static final String TAG = "WXEntryActivity";
    private static final int RETURN_MSG_TYPE_LOGIN = 1; //登录
    private static final int RETURN_MSG_TYPE_SHARE = 2; //分享
    private static final String APP_SECRET = "1e405b0b6c30c0b2e3bcd505d24d1ac7";
    public static final String WEIXIN_APP_ID = "wxb7c0df923d4f2b3f";
    wxpreIMpl wxpreIMpl;
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        wxpreIMpl = new wxpreIMpl(this);
        mContext = this;
        //如果没回调onResp，估计是这句没有写
        App.iwxapi.handleIntent(getIntent(), this);
    }


    // 微信发送请求到第三方应用时，会回调到该方法
    @Override
    public void onReq(BaseReq baseReq) {

    }

    // 第三方应用发送到微信的请求处理后的响应结果，会回调到该方法
    //app发送消息给微信，处理返回消息的回调
    @Override
    public void onResp(BaseResp baseResp) {
        Log.i(TAG, "onResp:------>");
        Log.i(TAG, "error_code:---->" + baseResp.errCode);
        int type = baseResp.getType(); //类型：分享还是登录
        switch (baseResp.errCode) {
            case BaseResp.ErrCode.ERR_AUTH_DENIED:
            case BaseResp.ErrCode.ERR_USER_CANCEL:
                //用户取消
                String message = "";
                if (type == RETURN_MSG_TYPE_LOGIN) {
                    message = "取消了微信登录";
                } else if (type == RETURN_MSG_TYPE_SHARE) {
                    message = "取消了微信分享";
                }

                break;
            case BaseResp.ErrCode.ERR_OK:
                //用户同意
                if (type == RETURN_MSG_TYPE_LOGIN) {
                    //用户换取access_token的code，仅在ErrCode为0时有效
                    String code = ((SendAuth.Resp) baseResp).code;
                    Log.i(TAG, "code:------>" + code);

                    //这里拿到了这个code，去做2次网络请求获取access_token和用户个人信息x`x`
                    getAccessToken(code);

                } else if (type == RETURN_MSG_TYPE_SHARE) {

                }
                break;
        }
    }

    /**
     * 获取access_token：
     *
     * @param code 用户或取access_token的code，仅在ErrCode为0时有效
     */
    private void getAccessToken(final String code) {
        String path = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="
                + WEIXIN_APP_ID
                + "&secret="
                + APP_SECRET
                + "&code="
                + code
                + "&grant_type=authorization_code";
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().get().url(path).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                wxtoken wxdata = gson.fromJson(response.body().string(), com.toobi.toobi.wxapi.wxtoken.class);
                String access_token = wxdata.getAccess_token(); //接口调用凭证
                String openid = wxdata.getOpenid(); //授权用户唯一标识
                UserManage.getInstance().saveUserInfo(WXEntryActivity.this, null,null, null, access_token, openid);
                //当且仅当该移动应用已获得该用户的userinfo授权时，才会出现该字段
                String unionid = wxdata.getUnionid();
                Log.i(TAG, "access_token:----->" + access_token);
                Log.i(TAG, "openid:----->" + openid);
                Log.i(TAG, "unionid:----->" + unionid);
                getWXUserInfo(access_token, openid, unionid);
            }
        });

    }

    /**
     * 获取微信登录，用户授权后的个人信息
     *
     * @param access_token
     * @param openid
     * @param unionid
     */
    private void getWXUserInfo(final String access_token, final String openid, final String unionid) {
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
                Log.i(TAG, "getWXUserInfo:--------> onNext");
                String country = wxdata.getCountry(); //国家
                String province = wxdata.getProvince(); //省
                String city = wxdata.getCity(); //市
                String nickname = wxdata.getNickname(); //用户名
                int sex = wxdata.getSex(); //性别
                String headimgurl = wxdata.getHeadimgurl(); //头像url
                HashMap<String, String> map = new HashMap<>();
                map.put("openid", openid);
                map.put("userName", wxdata.getNickname());
                map.put("avatar", wxdata.getHeadimgurl());
                wxpreIMpl.getLoginPost(map);
                Log.i(TAG, "country:-------->" + country);
                Log.i(TAG, "province:-------->" + province);
                Log.i(TAG, "city:-------->" + city);
                Log.i(TAG, "nickname:-------->" + nickname);
                Log.i(TAG, "sex:-------->" + sex);
                Log.i(TAG, "headimgurl:-------->" + headimgurl);
            }
        });

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

    }
}


