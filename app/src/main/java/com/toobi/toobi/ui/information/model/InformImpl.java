package com.toobi.toobi.ui.information.model;


import com.toobi.toobi.ui.information.presenter.InformPersenter;

import java.util.HashMap;

/**
 * Created by Rampant on 2017/11/6.
 */

public interface InformImpl {
    void InformGet(String url, InformPersenter informPersenter);
    void sInformGet(String url, InformPersenter informPersenter);
    void xInformGet(String url, InformPersenter informPersenter);
    void followGet(HashMap<String,String> url, InformPersenter informPersenter);
    void userinfoGet(String url, InformPersenter informPersenter);
    void intoroomGet(HashMap<String,String> url, InformPersenter informPersenter);
    void takeGet(HashMap<String,String> url, InformPersenter informPersenter);
}
