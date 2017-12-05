package com.toobi.toobi.wxapi.model;

import com.toobi.toobi.ui.register.presenter.Registerpresenter;
import com.toobi.toobi.wxapi.presenter.wxpreIMpl;

import java.util.HashMap;

/**
 * Created by Rampant on 2017/11/16.
 */

public interface ModelIMpl {
    void getLoginPost(HashMap<String, String> map, wxpreIMpl registerpresenter);
}
