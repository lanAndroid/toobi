package com.toobi.toobi.ui.information.model;



import com.toobi.toobi.ui.information.presenter.InformPersenter;
import com.toobi.toobi.utils.entry.InformBean;
import com.toobi.toobi.utils.entry.followbean;
import com.toobi.toobi.utils.entry.intoRoom;
import com.toobi.toobi.utils.entry.takeOff;
import com.toobi.toobi.utils.entry.userInfo;
import com.toobi.toobi.utils.retrofit.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Rampant on 2017/11/6.
 */

public class InformModel implements InformImpl {
    @Override
    public void InformGet(String url, final InformPersenter informPersenter) {
        RetrofitUtils.getmRetrofitUtils().getInform(url, new Observer<InformBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(InformBean informBean) {
                informPersenter.InformGet(informBean);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void sInformGet(String url, final InformPersenter informPersenter) {
        RetrofitUtils.getmRetrofitUtils().getInform(url, new Observer<InformBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(InformBean informBean) {
                informPersenter.sInformGet(informBean);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void xInformGet(String url, final InformPersenter informPersenter) {
        RetrofitUtils.getmRetrofitUtils().getInform(url, new Observer<InformBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(InformBean informBean) {
                informPersenter.xInformGet(informBean);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void followGet(HashMap<String, String> url, final InformPersenter informPersenter) {
        RetrofitUtils.getmRetrofitUtils().getfollowbean(url, new Observer<followbean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(followbean followbean) {
                informPersenter.followGet(followbean);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void userinfoGet(String url, final InformPersenter informPersenter) {
        RetrofitUtils.getmRetrofitUtils().geuserInfo(url, new Observer<userInfo>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(userInfo userInfo) {
                informPersenter.userGet(userInfo);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void intoroomGet(HashMap<String, String> url, final InformPersenter informPersenter) {
        RetrofitUtils.getmRetrofitUtils().getintoRoom(url, new Observer<intoRoom>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(intoRoom intoRoom) {
                informPersenter.intoGet(intoRoom);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void takeGet(HashMap<String, String> url, final InformPersenter informPersenter) {
        RetrofitUtils.getmRetrofitUtils().gettakeoff(url, new Observer<takeOff>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(takeOff takeOff) {
                informPersenter.takeGet(takeOff);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
