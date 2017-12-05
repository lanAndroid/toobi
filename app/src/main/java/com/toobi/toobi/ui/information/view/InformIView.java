package com.toobi.toobi.ui.information.view;


import com.toobi.toobi.utils.entry.InformBean;
import com.toobi.toobi.utils.entry.follow;
import com.toobi.toobi.utils.entry.followbean;
import com.toobi.toobi.utils.entry.intoRoom;
import com.toobi.toobi.utils.entry.takeOff;
import com.toobi.toobi.utils.entry.userInfo;

/**
 * Created by Rampant on 2017/11/6.
 */

public interface InformIView {

    void Informsucceed(InformBean informBean);

    void sInformsucceed(InformBean informBean);

    void xInformsucceed(InformBean informBean);

    void followsucceed(followbean informBean);

    void usersucceed(userInfo informBean);

    void intosucceed(intoRoom informBean);

    void takesucceed(takeOff informBean);

    // 失败
    void nothing(String nothing);
}
