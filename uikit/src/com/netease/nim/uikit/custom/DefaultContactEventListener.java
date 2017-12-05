package com.netease.nim.uikit.custom;

import android.content.Context;

import com.netease.nim.uikit.NimUIKit;
import com.netease.nim.uikit.contact.ContactEventListener;

import java.util.Map;

/**
 * ContactEventListener 通讯录联系人列表一些点击事件的响应处理
 * <p>
 * DefaultContactEventListener 提供了默认处理，其中点击Item 和 Avatar 响应为打开P2P聊天界面
 * <p>
 * Created by hzchenkang on 2016/12/21.
 */

public class DefaultContactEventListener implements ContactEventListener {


    @Override
    public void onItemClick(Context context, String account, Map<String, Object> map) {
        NimUIKit.startP2PSession(context, account);
    }

    @Override
    public void onItemLongClick(Context context, String account, Map<String, Object> map) {

    }

    @Override
    public void onAvatarClick(Context context, String account, Map<String, Object> ma) {
        NimUIKit.startP2PSession(context, account);
    }


}
