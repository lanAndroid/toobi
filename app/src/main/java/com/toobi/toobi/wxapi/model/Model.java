package com.toobi.toobi.wxapi.model;


import com.toobi.toobi.ui.register.presenter.Registerpresenter;
import com.toobi.toobi.utils.entry.LoginBean;
import com.toobi.toobi.utils.retrofit.RetrofitUtils;
import com.toobi.toobi.wxapi.presenter.wxpreIMpl;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Rampant on 2017/11/16.
 */

public class Model implements ModelIMpl {
    @Override
    public void getLoginPost(HashMap<String, String> map, final wxpreIMpl registerpresenter) {
        RetrofitUtils.getmRetrofitUtils().getloin2(map, new Observer<LoginBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(LoginBean loginBean) {
                registerpresenter.getLoginPost(loginBean);
            }

            @Override
            public void onError(Throwable e) {
                registerpresenter.getlloginno("");
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
