package com.toobi.toobi.ui.information.presenter;


import com.toobi.toobi.ui.information.model.InformModel;
import com.toobi.toobi.ui.information.view.InformIView;
import com.toobi.toobi.utils.entry.InformBean;
import com.toobi.toobi.utils.entry.followbean;
import com.toobi.toobi.utils.entry.intoRoom;
import com.toobi.toobi.utils.entry.takeOff;
import com.toobi.toobi.utils.entry.userInfo;

import java.util.HashMap;

/**
 * Created by Rampant on 2017/11/6.
 */

public class InformPersenter implements InformPerImpl {
    private InformIView informIView;
    private InformModel informModel;

    public InformPersenter(InformIView informIView) {
        this.informIView = informIView;
        informModel = new InformModel();
    }

    @Override
    public void InformGet(String url) {
        informModel.InformGet(url, this);
    }

    @Override
    public void InformGet(InformBean informBean) {
        informIView.Informsucceed(informBean);
    }

    @Override
    public void sInformGet(String url) {
        informModel.sInformGet(url, this);
    }

    @Override
    public void sInformGet(InformBean informBean) {
        informIView.sInformsucceed(informBean);
    }

    @Override
    public void xInformGet(String url) {
        informModel.xInformGet(url, this);
    }

    @Override
    public void xInformGet(InformBean informBean) {
        informIView.xInformsucceed(informBean);
    }

    @Override
    public void followGet(HashMap<String, String> url) {
        informModel.followGet(url, this);
    }

    @Override
    public void followGet(followbean followbean) {
        informIView.followsucceed(followbean);
    }

    @Override
    public void userGet(String url) {
        informModel.userinfoGet(url, this);
    }

    @Override
    public void userGet(userInfo userInfo) {
        informIView.usersucceed(userInfo);
    }

    @Override
    public void intoGet(HashMap<String, String> url) {
        informModel.intoroomGet(url, this);
    }

    @Override
    public void intoGet(intoRoom intoRoom) {
        informIView.intosucceed(intoRoom);
    }

    @Override
    public void takeGet(HashMap<String, String> url) {
        informModel.takeGet(url, this);
    }

    @Override
    public void takeGet(takeOff intoRoom) {
        informIView.takesucceed(intoRoom);
    }

    @Override
    public void nothing(String nothing) {

    }
}
