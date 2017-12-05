package com.toobi.toobi.ui.homepage.model;


import com.toobi.toobi.ui.homepage.persenter.HomePagerPersenter;
import com.toobi.toobi.utils.entry.chatNum;
import com.toobi.toobi.utils.entry.creatRoom;
import com.toobi.toobi.utils.entry.roomSearch;
import com.toobi.toobi.utils.retrofit.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Rampant on 2017/11/6.
 */

public class HomepagerImpl implements HomePageModel {
    @Override
    public void HomepagerPost(HashMap<String, String> map, final HomePagerPersenter homePager) {
        RetrofitUtils.getmRetrofitUtils().getcreatroom(map, new Observer<creatRoom>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(creatRoom creatRoom) {
                homePager.HomePagerPOST(creatRoom);
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
    public void HomeRoomPost(String map, final HomePagerPersenter homePager) {
        RetrofitUtils.getmRetrofitUtils().getroomSearch(map, new Observer<roomSearch>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(roomSearch roomSearch) {
                homePager.HomeRoomPOST(roomSearch);
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
    public void Homechatnum(final HomePagerPersenter homePager) {
        RetrofitUtils.getmRetrofitUtils().getchatNum(new Observer<chatNum>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(chatNum chatNum) {
                homePager.Homechatnum(chatNum);
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
