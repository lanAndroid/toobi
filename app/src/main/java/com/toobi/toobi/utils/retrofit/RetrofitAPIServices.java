package com.toobi.toobi.utils.retrofit;


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

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Url;

/**
 * Created by Rampant on 2017/11/1.
 */

public interface RetrofitAPIServices {

    @FormUrlEncoded
    @POST("getCode")
    Observable<iphonenumber> getRegister(@FieldMap HashMap<String, String> map);


    @FormUrlEncoded
    @POST("checkReg")
    Observable<RegisTwo> getRegisterTwo(@FieldMap HashMap<String, String> map);


    @FormUrlEncoded
    @POST("backPassword")
    Observable<backpassword> getbackpassword(@FieldMap HashMap<String, String> map);

    @FormUrlEncoded
    @POST("login")
    Observable<LoginBean> getlogin(@FieldMap HashMap<String, String> map);


    @Multipart
    @POST("avatar")
    Observable<photo> upload(@Part MultipartBody.Part file);

    @FormUrlEncoded
    @POST("register")
    Observable<register> getregister(@FieldMap HashMap<String, Object> map);

    @GET()
    Observable<InformBean> getInform(@Url String url);

    @FormUrlEncoded
    @POST("creatRoom")
    Observable<creatRoom> getcreatRoom(@FieldMap HashMap<String, String> map);


    @GET()
    Observable<roomSearch> getroomSearch(@Url String map);

    @FormUrlEncoded
    @POST("userInfoUpdate")
    Observable<userInfoUpdate> getuserInfoUpdate(@FieldMap HashMap<String, String> map);

    @GET()
    Observable<follow> getfollow(@Url String url);

    @GET()
    Observable<fans> getfans(@Url String url);

    @GET()
    Observable<chatRoomList> getchatRoomList(@Url String url);

    @FormUrlEncoded
    @POST("follow")
    Observable<followbean> getfollowbean(@FieldMap HashMap<String, String> map);

    @GET()
    Observable<userInfo> geuserInfo(@Url String url);

    @FormUrlEncoded
    @POST("intoRoom")
    Observable<intoRoom> getintoRoom(@FieldMap HashMap<String, String> map);

    @FormUrlEncoded
    @POST("takeOff")
    Observable<takeOff> gettakeOff(@FieldMap HashMap<String, String> map);

    @FormUrlEncoded
    @POST("suggest")
    Observable<suggest> getsuggest(@FieldMap HashMap<String, String> map);

    @FormUrlEncoded
    @POST("loginWechat")
    Observable<LoginBean> getlogin2(@FieldMap HashMap<String, String> map);


    @GET("chatNum")
    Observable<chatNum> getchatNum();


    //api/myRoom/uid/5
    @GET()
    Observable<myRoom> getmyroom(@Url String url);
}
