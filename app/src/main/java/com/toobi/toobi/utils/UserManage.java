package com.toobi.toobi.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.toobi.toobi.utils.entry.Userofo;

/**
 * Created by Rampant on 2017/11/17.
 */

public class UserManage {
    private static UserManage instance;

    private UserManage() {
    }

    public static UserManage getInstance() {
        if (instance == null) {
            instance = new UserManage();
        }
        return instance;
    }


    /**
     * 保存自动登录的用户信息
     */
    public void saveUserInfo(Context context, String username, String id, String password, String token, String openid) {
        SharedPreferences sp = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);//Context.MODE_PRIVATE表示SharePrefences的数据只有自己应用程序能访问。
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("USER_NAME", username);
        editor.putString("PASSWORD", password);
        editor.putString("ID", id);
        editor.putString("APPTOKEN", token);
        editor.putString("OPENID", openid);
        editor.commit();
    }


    /**
     * 获取用户信息model
     *
     * @param context
     * @param
     * @param
     */
    public Userofo getUserInfo(Context context) {
        SharedPreferences sp = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        Userofo userInfo = new Userofo();
        userInfo.setUserName(sp.getString("USER_NAME", ""));
        userInfo.setPassword(sp.getString("PASSWORD", ""));
        userInfo.setToken(sp.getString("APPTOKEN", ""));
        userInfo.setId(sp.getString("ID", ""));
        userInfo.setOpenid(sp.getString("OPENID", ""));
        return userInfo;

    }


    /**
     * userInfo中是否有数据
     */
    public boolean hasUserInfo(Context context) {
        Userofo userInfo = getUserInfo(context);
        if (userInfo != null) {
            if ((!TextUtils.isEmpty(userInfo.getUserName())) && (!TextUtils.isEmpty(userInfo.getPassword()))) {//有数据
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public void disspass(Context context) {
        SharedPreferences sp = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        sp.edit().clear().commit();
    }
}
