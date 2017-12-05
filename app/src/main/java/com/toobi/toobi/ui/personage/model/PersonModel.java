package com.toobi.toobi.ui.personage.model;


import com.toobi.toobi.ui.personage.presenter.PersonPresenter;
import com.toobi.toobi.utils.entry.LoginBean;
import com.toobi.toobi.utils.entry.fans;
import com.toobi.toobi.utils.entry.myRoom;
import com.toobi.toobi.utils.entry.suggest;
import com.toobi.toobi.utils.entry.userInfoUpdate;
import com.toobi.toobi.utils.retrofit.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Rampant on 2017/11/8.
 */

public class PersonModel implements PersonImpl {

    @Override
    public void getuserInfoUpdate(HashMap<String, String> map, final PersonPresenter personPresenter) {
        RetrofitUtils.getmRetrofitUtils().getuserInfoUpdate(map, new Observer<userInfoUpdate>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(userInfoUpdate userInfoUpdate) {
                personPresenter.getuserInfoUpdatePOST(userInfoUpdate);
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
    public void getlogin(HashMap<String, String> map, final PersonPresenter personPresenter) {
        RetrofitUtils.getmRetrofitUtils().getloin(map, new Observer<LoginBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(LoginBean loginBean) {
                personPresenter.getlogin(loginBean);
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
    public void getsuggest(HashMap<String, String> map, final PersonPresenter personPresenter) {
        RetrofitUtils.getmRetrofitUtils().getsuggest(map, new Observer<suggest>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(suggest suggest) {
                personPresenter.getsuggest(suggest);
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
    public void getfans(String url, final PersonPresenter personPresenter) {
        RetrofitUtils.getmRetrofitUtils().getfans(url, new Observer<fans>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(fans fans) {
                personPresenter.getfans(fans);
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
    public void getmyroom(String url, final PersonPresenter personPresenter) {
        RetrofitUtils.getmRetrofitUtils().getmyroom(url, new Observer<myRoom>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(myRoom myRoom) {
                personPresenter.getmyroom(myRoom);
            }

            @Override
            public void onError(Throwable e) {
                personPresenter.nothing();
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
