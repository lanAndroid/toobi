package com.toobi.toobi.ui.register.model;

import android.util.Log;
import android.widget.Toast;

import com.toobi.toobi.ui.register.model.RegisterImpl;
import com.toobi.toobi.ui.register.presenter.Registerpresenter;
import com.toobi.toobi.ui.register.presenter.registerpreIMpl;
import com.toobi.toobi.utils.entry.LoginBean;
import com.toobi.toobi.utils.entry.RegisTwo;
import com.toobi.toobi.utils.entry.backpassword;
import com.toobi.toobi.utils.entry.iphonenumber;
import com.toobi.toobi.utils.entry.photo;
import com.toobi.toobi.utils.entry.register;
import com.toobi.toobi.utils.retrofit.RetrofitUtils;


import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by Rampant on 2017/11/1.
 */

public class RegisterModel implements RegisterImpl {


    @Override
    public void getRegisterPost(HashMap<String, String> map, final Registerpresenter registerpresenter) {
        RetrofitUtils.getmRetrofitUtils().getRegister(map, new Observer<iphonenumber>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(iphonenumber iphonenumber) {
                registerpresenter.getRegisterPost(iphonenumber);
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
    public void getbackpassword(HashMap<String, String> map, final Registerpresenter registerpresenter) {
        RetrofitUtils.getmRetrofitUtils().getbackpassword(map, new Observer<backpassword>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(backpassword backpassword) {
                registerpresenter.getbackpostword(backpassword);
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
    public void getRegTwoPost(HashMap<String, String> map, final Registerpresenter registerpresenter) {
        RetrofitUtils.getmRetrofitUtils().getRegTwor(map, new Observer<RegisTwo>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(RegisTwo regisTwo) {
                registerpresenter.getRegTwoPost(regisTwo);
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
    public void getLoginPost(HashMap<String, String> map, final Registerpresenter registerpresenter) {
        RetrofitUtils.getmRetrofitUtils().getloin(map, new Observer<LoginBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(LoginBean loginBean) {
                registerpresenter.getLoginPost(loginBean);
            }

            @Override
            public void onError(Throwable e) {
                registerpresenter.getLoginPost("失败");
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void getphotoPost(String path, final registerpreIMpl registerpresenter) {
        RetrofitUtils.getmRetrofitUtils().upload(path, new Observer<photo>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(photo photo) {
                Log.e("----------1111", "成功");
                registerpresenter.getphotoPost(photo);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("----------1111", "失败");
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void getregisPost(HashMap<String, Object> map, final Registerpresenter registerpresenter) {
        RetrofitUtils.getmRetrofitUtils().getregist(map, new Observer<register>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(register register) {
                registerpresenter.getregisterPost(register);
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
