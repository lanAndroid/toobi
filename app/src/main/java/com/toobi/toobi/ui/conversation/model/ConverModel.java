package com.toobi.toobi.ui.conversation.model;



import com.toobi.toobi.ui.conversation.persenter.ConverPersenter;
import com.toobi.toobi.utils.entry.chatRoomList;
import com.toobi.toobi.utils.entry.fans;
import com.toobi.toobi.utils.entry.follow;
import com.toobi.toobi.utils.retrofit.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Rampant on 2017/11/8.
 */

public class ConverModel implements ConverImpl {
    @Override
    public void getfollow(String url, final ConverPersenter converPersenter) {
        RetrofitUtils.getmRetrofitUtils().getfollow(url, new Observer<follow>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(follow follow) {
                converPersenter.getfollow(follow);
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
    public void getfans(String url, final ConverPersenter converPersenter) {
        RetrofitUtils.getmRetrofitUtils().getfans(url, new Observer<fans>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(fans fans) {
                converPersenter.getfans(fans);
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
    public void getchat(String url, final ConverPersenter converPersenter) {
        RetrofitUtils.getmRetrofitUtils().getchatRoomList(url, new Observer<chatRoomList>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(chatRoomList chatRoomList) {
                converPersenter.getchat(chatRoomList);
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
