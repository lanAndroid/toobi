package com.toobi.toobi.utils.retrofit;

import android.os.Environment;
import android.util.Log;

import com.netease.nimlib.sdk.RequestCallback;
import com.toobi.toobi.utils.entry.InformBean;
import com.toobi.toobi.utils.entry.LoginBean;
import com.toobi.toobi.utils.entry.RegisTwo;
import com.toobi.toobi.utils.entry.backpassword;
import com.toobi.toobi.utils.entry.chatNum;
import com.toobi.toobi.utils.entry.chatRoomList;
import com.toobi.toobi.utils.entry.creatRoom;
import com.toobi.toobi.utils.entry.fans;
import com.toobi.toobi.utils.entry.follow;
import com.toobi.toobi.utils.entry.followbean;
import com.toobi.toobi.utils.entry.intoRoom;
import com.toobi.toobi.utils.entry.iphonenumber;
import com.toobi.toobi.utils.entry.myRoom;
import com.toobi.toobi.utils.entry.photo;
import com.toobi.toobi.utils.entry.register;
import com.toobi.toobi.utils.entry.roomSearch;
import com.toobi.toobi.utils.entry.suggest;
import com.toobi.toobi.utils.entry.takeOff;
import com.toobi.toobi.utils.entry.userInfo;
import com.toobi.toobi.utils.entry.userInfoUpdate;
import com.toobi.toobi.utils.retrofit.RetrofitAPIServices;


import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Part;

/**
 * Created by Rampant on 2017/11/1.
 */

public class RetrofitUtils {

    private static RetrofitUtils mRetrofitUtils = null;
    private final RetrofitAPIServices apiServices;
    private final OkHttpClient okhttp;

    private RetrofitUtils() {

        okhttp = new OkHttpClient.Builder()
                .connectTimeout(50, TimeUnit.SECONDS)
                .readTimeout(50, TimeUnit.SECONDS)
                .writeTimeout(50, TimeUnit.SECONDS)
                .build();

        apiServices = new Retrofit.Builder()
                .client(okhttp)
                // 测试 https://www.mini798.com/api/v1/
                // 正式 https://www.imtoobi.com/api/v1/
                .baseUrl("https://www.imtoobi.com/api/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build().create(RetrofitAPIServices.class);

    }

    public static RetrofitUtils getmRetrofitUtils() {
        if (mRetrofitUtils == null)
            mRetrofitUtils = new RetrofitUtils();
        return mRetrofitUtils;
    }


    public void getRegister(HashMap<String, String> map, Observer<iphonenumber> observer) {
        Observable<iphonenumber> register = apiServices.getRegister(map);
        register.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    public void getRegTwor(HashMap<String, String> map, Observer<RegisTwo> observer) {
        Observable<RegisTwo> register = apiServices.getRegisterTwo(map);
        register.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    public void getbackpassword(HashMap<String, String> map, Observer<backpassword> observer) {
        Observable<backpassword> observable = apiServices.getbackpassword(map);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    public void getloin(HashMap<String, String> map, Observer<LoginBean> observer) {
        Observable<LoginBean> observable = apiServices.getlogin(map);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    public void getloin2(HashMap<String, String> map, Observer<LoginBean> observer) {
        Observable<LoginBean> observable = apiServices.getlogin2(map);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    public void upload(String path, Observer<photo> observer) {
        File file = new File(path);
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/png"), file);
        MultipartBody.Part part = MultipartBody.Part.createFormData("pic", file.getName(), requestBody);
        Observable<photo> observable = apiServices.upload(part);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    public void getInform(String url, Observer<InformBean> observer) {

        Observable<InformBean> observable = apiServices.getInform(url);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    public void getregist(HashMap<String, Object> map, Observer<register> observer) {

        Observable<register> observable = apiServices.getregister(map);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    public void getcreatroom(HashMap<String, String> map, Observer<creatRoom> observer) {

        Observable<creatRoom> observable = apiServices.getcreatRoom(map);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    public void getroomSearch(String map, Observer<roomSearch> observer) {

        Observable<roomSearch> observable = apiServices.getroomSearch(map);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    public void getuserInfoUpdate(HashMap<String, String> map, Observer<userInfoUpdate> observer) {

        Observable<userInfoUpdate> observable = apiServices.getuserInfoUpdate(map);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    public void getfollow(String url, Observer<follow> observer) {
        Observable<follow> observable = apiServices.getfollow(url);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    public void getfans(String url, Observer<fans> observer) {
        Observable<fans> observable = apiServices.getfans(url);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    public void getchatRoomList(String url, Observer<chatRoomList> observer) {
        Observable<chatRoomList> observable = apiServices.getchatRoomList(url);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    public void getfollowbean(HashMap<String, String> map, Observer<followbean> observer) {
        Observable<followbean> observable = apiServices.getfollowbean(map);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    public void geuserInfo(String url, Observer<userInfo> observer) {
        Observable<userInfo> observable = apiServices.geuserInfo(url);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    public void getintoRoom(HashMap<String, String> map, Observer<intoRoom> observer) {
        Observable<intoRoom> observable = apiServices.getintoRoom(map);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    public void gettakeoff(HashMap<String, String> map, Observer<takeOff> observer) {
        Observable<takeOff> observable = apiServices.gettakeOff(map);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    public void getsuggest(HashMap<String, String> map, Observer<suggest> observer) {
        Observable<suggest> observable = apiServices.getsuggest(map);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    public void getchatNum(Observer<chatNum> observer) {
        Observable<chatNum> observable = apiServices.getchatNum();
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    public void getmyroom(String url, Observer<myRoom> observer) {
        Observable<myRoom> observable = apiServices.getmyroom(url);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }
}
