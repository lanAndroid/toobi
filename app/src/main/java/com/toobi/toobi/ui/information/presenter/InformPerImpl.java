package com.toobi.toobi.ui.information.presenter;


import com.toobi.toobi.utils.entry.InformBean;
import com.toobi.toobi.utils.entry.follow;
import com.toobi.toobi.utils.entry.followbean;
import com.toobi.toobi.utils.entry.intoRoom;
import com.toobi.toobi.utils.entry.takeOff;
import com.toobi.toobi.utils.entry.userInfo;

import java.util.HashMap;

/**
 * Created by Rampant on 2017/11/6.
 */

public interface InformPerImpl {
    void InformGet(String url);

    void InformGet(InformBean informBean);

    void sInformGet(String url);

    void sInformGet(InformBean informBean);

    void xInformGet(String url);

    void xInformGet(InformBean informBean);

    void followGet(HashMap<String, String> url);

    void followGet(followbean followbean);

    void userGet(String url);

    void userGet(userInfo userInfo);

    void intoGet(HashMap<String, String> url);

    void intoGet(intoRoom intoRoom);

    void takeGet(HashMap<String, String> url);

    void takeGet(takeOff intoRoom);

    void nothing(String nothing);
}
