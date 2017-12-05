package com.toobi.toobi.ui.register.presenter;



import com.toobi.toobi.utils.entry.LoginBean;
import com.toobi.toobi.utils.entry.RegisTwo;
import com.toobi.toobi.utils.entry.backpassword;
import com.toobi.toobi.utils.entry.iphonenumber;
import com.toobi.toobi.utils.entry.photo;
import com.toobi.toobi.utils.entry.register;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by Rampant on 2017/11/1.
 */

public interface Registerpresenter {

    void getRegisterPost(HashMap<String, String> map);

    void getRegisterPost(iphonenumber iphonenumber);

    void getbackpostword(HashMap<String, String> map);

    void getbackpostword(backpassword backpassword);

    void getRegTwoPost(HashMap<String, String> map);

    void getRegTwoPost(RegisTwo regisTwo);

    void getLoginPost(HashMap<String, String> map);

    void getLoginPost(LoginBean loginBean);

    void getLoginPost(String str);


    void getphotoPost(String paht);

    void getphotoPost(photo photo);

    void getregisterPost(HashMap<String, Object> map);

    void getregisterPost(register loginBean);
}
