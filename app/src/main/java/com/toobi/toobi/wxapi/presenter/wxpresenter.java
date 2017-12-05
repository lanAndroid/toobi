package com.toobi.toobi.wxapi.presenter;


import com.toobi.toobi.utils.entry.LoginBean;
import com.toobi.toobi.utils.entry.RegisTwo;
import com.toobi.toobi.utils.entry.backpassword;
import com.toobi.toobi.utils.entry.iphonenumber;
import com.toobi.toobi.utils.entry.photo;
import com.toobi.toobi.utils.entry.register;

import java.util.HashMap;

import okhttp3.MultipartBody;

/**
 * Created by Rampant on 2017/11/1.
 */

public interface wxpresenter {

    void getLoginPost(HashMap<String, String> map);
    void getlloginno(String str);
    void getLoginPost(LoginBean loginBean);

}
