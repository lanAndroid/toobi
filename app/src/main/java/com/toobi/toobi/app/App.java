package com.toobi.toobi.app;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Environment;
import android.support.multidex.MultiDexApplication;
import android.text.TextUtils;


import com.netease.nim.uikit.NimUIKit;
import com.netease.nim.uikit.ait.selector.AitContactSelectorActivity;
import com.netease.nim.uikit.core.UserPreferences;
import com.netease.nim.uikit.session.activity.P2PMessageActivity;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.SDKOptions;
import com.netease.nimlib.sdk.StatusBarNotificationConfig;
import com.netease.nimlib.sdk.auth.LoginInfo;
import com.netease.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.netease.nimlib.sdk.uinfo.UserInfoProvider;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.toobi.toobi.R;
import com.toobi.toobi.base.BaseActivity;
import com.toobi.toobi.base.BaseFragment;
import com.toobi.toobi.ui.homepage.view.HomePageActivity;
import com.toobi.toobi.ui.information.view.InformFragment;
import com.toobi.toobi.utils.amap.NimDemoLocationProvider;
import com.umeng.analytics.MobclickAgent;

import java.io.IOException;


/**
 * Created by Rampant on 2017/11/3.
 */

public class App extends MultiDexApplication {

    public static BaseActivity baseActivity;
    public static BaseFragment baseFragment;

    public static String APP_ID = "wxb7c0df923d4f2b3f";
    public static IWXAPI iwxapi;

    @Override
    public void onCreate() {
        super.onCreate();
        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
        //MobclickAgent. startWithConfigure( new MobclickAgent.UMAnalyticsConfig(this, APP_KAY, market, MobclickAgent.EScenarioType.E_UM_NORMAL,true));
        NIMClient.init(this, loginInfo(), options());
        registToWX();
        if (inMainProcess()) {
            initUiKit();
        }
    }

    private void registToWX() {
        //AppConst.WEIXIN.APP_ID是指你应用在微信开放平台上的AppID，记得替换。
        iwxapi = WXAPIFactory.createWXAPI(this, APP_ID, false);
        // 将该app注册到微信
        iwxapi.registerApp(APP_ID);
    }

    private void initUiKit() {
        // 初始化
        NimUIKit.init(this);
        NimUIKit.setLocationProvider(new NimDemoLocationProvider());
        getAppCacheDir(this);
        // 云信sdk相关业务初始化
        // 会话窗口的定制: 示例代码可详见demo源码中的SessionHelper类。
        // 1.注册自定义消息附件解析器（可选）
        // 2.注册各种扩展消息类型的显示ViewHolder（可选）
        // 3.设置会话中点击事件响应处理（一般需要）

    }


    public boolean inMainProcess() {
        String packageName = getPackageName();
        String processName = SystemUtil.getProcessName(this);
        return packageName.equals(processName);
    }

    // 如果返回值为 null，则全部使用默认参数。
    private SDKOptions options() {
        SDKOptions options = new SDKOptions();
        // 如果将新消息通知提醒托管给 SDK 完成，需要添加以下配置。否则无需设置。
        StatusBarNotificationConfig config = new StatusBarNotificationConfig();
        config.notificationEntrance = HomePageActivity.class;
        config.notificationSmallIconId = R.mipmap.toobi;
        // 呼吸灯配置
        config.ledARGB = Color.GREEN;
        config.ledOnMs = 1000;
        config.ledOffMs = 1500;
        // 通知铃声的uri字符串ro.config.ringtone
        //android.resource://com.netease.nim.demo/raw/msg
        config.notificationSound = "android.resource://com.netease.nim.demo/raw/msg";
        options.statusBarNotificationConfig = config;
        // 配置保存图片，文件，log 等数据的目录
        // 如果 options 中没有设置这个值，SDK 会使用下面代码示例中的位置作为 SDK 的数据目录。
        // 该目录目前包含 log, file, image, audio, video, thumb 这6个目录。
        // 如果第三方 APP 需要缓存清理功能， 清理这个目录下面个子目录的内容即可。
        String sdkPath = Environment.getExternalStorageDirectory() + "/" + getPackageName() + "/nim";
        options.sdkStorageRootPath = sdkPath;
        // 配置是否需要预下载附件缩略图，默认为 true
        options.preloadAttach = true;
        // 配置附件缩略图的尺寸大小。表示向服务器请求缩略图文件的大小
        // 该值一般应根据屏幕尺寸来确定， 默认值为 Screen.width / 2
        options.thumbnailSize = 100;
        // 用户资料提供者, 目前主要用于提供用户资料，用于新消息通知栏中显示消息来源的头像和昵称
        options.userInfoProvider = new UserInfoProvider() {
            @Override
            public UserInfo getUserInfo(String account) {
                UserInfo userInfo = NimUIKit.getUserInfoProvider().getUserInfo(account);
                return userInfo;
            }

            @Override
            public int getDefaultIconResId() {
                return R.mipmap.toobi;
            }

            @Override
            public Bitmap getTeamIcon(String tid) {
                Bitmap bitmap = NimUIKit.getUserInfoProvider().getTeamIcon(tid);
                return bitmap;
            }

            @Override
            public Bitmap getAvatarForMessageNotifier(String account) {
                Bitmap bitmap = NimUIKit.getUserInfoProvider().getAvatarForMessageNotifier(account);
                return bitmap;
            }

            @Override
            public String getDisplayNameForMessageNotifier(String account, String sessionId,
                                                           SessionTypeEnum sessionType) {
                String bitmap = NimUIKit.getUserInfoProvider().getDisplayNameForMessageNotifier(account, sessionId, sessionType);
                return bitmap;
            }
        };
        return options;
    }

    /**
     * 配置 APP 保存图片/语音/文件/log等数据的目录
     * 这里示例用SD卡的应用扩展存储目录
     */
    static String getAppCacheDir(Context context) {
        String storageRootPath = null;
        try {
            // SD卡应用扩展存储区(APP卸载后，该目录下被清除，用户也可以在设置界面中手动清除)，请根据APP对数据缓存的重要性及生命周期来决定是否采用此缓存目录.
            // 该存储区在API 19以上不需要写权限，即可配置 <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" android:maxSdkVersion="18"/>
            if (context.getExternalCacheDir() != null) {
                storageRootPath = context.getExternalCacheDir().getCanonicalPath();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(storageRootPath)) {
            // SD卡应用公共存储区(APP卸载后，该目录不会被清除，下载安装APP后，缓存数据依然可以被加载。SDK默认使用此目录)，该存储区域需要写权限!
            storageRootPath = Environment.getExternalStorageDirectory() + "/" + DemoCache.getContext().getPackageName();
        }

        return storageRootPath;
    }

    // 如果已经存在用户登录信息，返回LoginInfo，否则返回null即可
    private LoginInfo loginInfo() {
        return null;
    }
}
