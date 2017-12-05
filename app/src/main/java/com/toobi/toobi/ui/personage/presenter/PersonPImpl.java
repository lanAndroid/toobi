package com.toobi.toobi.ui.personage.presenter;


import com.toobi.toobi.utils.entry.LoginBean;
import com.toobi.toobi.utils.entry.fans;
import com.toobi.toobi.utils.entry.myRoom;
import com.toobi.toobi.utils.entry.suggest;
import com.toobi.toobi.utils.entry.userInfoUpdate;

import java.util.HashMap;

/**
 * Created by Rampant on 2017/11/8.
 */

public interface PersonPImpl {
    void getuserInfoUpdatePOST(HashMap<String, String> map);

    void getuserInfoUpdatePOST(userInfoUpdate userInfoUpdate);

    void getlogin(HashMap<String, String> map);

    void getlogin(LoginBean loginBean);

    void getsuggest(HashMap<String, String> map);

    void getsuggest(suggest suggest);

    void getfans(String url);

    void getfans(fans suggest);


    void getmyroom(String url);

    void getmyroom(myRoom suggest);

    void nothing();
}
