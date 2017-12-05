package com.toobi.toobi.ui.register.model;


import com.toobi.toobi.ui.register.presenter.Registerpresenter;
import com.toobi.toobi.ui.register.presenter.registerpreIMpl;

import java.util.HashMap;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by Rampant on 2017/11/1.
 */

public interface RegisterImpl {
    void getRegisterPost(HashMap<String, String> map, Registerpresenter registerpresenter);

    void getbackpassword(HashMap<String, String> map, Registerpresenter registerpresenter);

    void getRegTwoPost(HashMap<String, String> map, Registerpresenter registerpresenter);

    void getLoginPost(HashMap<String, String> map, Registerpresenter registerpresenter);

    void getphotoPost(String path, registerpreIMpl registerpresenter);
    void getregisPost(HashMap<String, Object> map, Registerpresenter registerpresenter);
}
