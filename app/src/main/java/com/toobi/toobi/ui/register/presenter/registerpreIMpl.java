package com.toobi.toobi.ui.register.presenter;

import android.util.Log;


import com.toobi.toobi.ui.register.model.RegisterModel;
import com.toobi.toobi.ui.register.view.registerIView;
import com.toobi.toobi.utils.entry.LoginBean;
import com.toobi.toobi.utils.entry.RegisTwo;
import com.toobi.toobi.utils.entry.backpassword;
import com.toobi.toobi.utils.entry.iphonenumber;
import com.toobi.toobi.utils.entry.photo;
import com.toobi.toobi.utils.entry.register;

import java.util.HashMap;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by Rampant on 2017/11/1.
 */

public class registerpreIMpl implements Registerpresenter {
    private registerIView registerIView;
    private RegisterModel registerModel;

    public registerpreIMpl(registerIView registerIView) {
        this.registerIView = registerIView;
        registerModel = new RegisterModel();
    }

    @Override
    public void getRegisterPost(HashMap<String, String> map) {
        registerModel.getRegisterPost(map, this);
    }

    @Override
    public void getRegisterPost(iphonenumber iphonenumber) {
        registerIView.Regissucceed(iphonenumber);
    }


    @Override
    public void getbackpostword(HashMap<String, String> map) {
        registerModel.getbackpassword(map, this);
    }

    @Override
    public void getbackpostword(backpassword backpassword) {
        registerIView.backposswordsucceed(backpassword);
    }


    @Override
    public void getRegTwoPost(HashMap<String, String> map) {
        registerModel.getRegTwoPost(map, this);
    }

    @Override
    public void getRegTwoPost(RegisTwo regisTwo) {
        registerIView.RegisTwosucceed(regisTwo);
    }

    @Override
    public void getLoginPost(HashMap<String, String> map) {
        registerModel.getLoginPost(map, this);
    }

    @Override
    public void getLoginPost(LoginBean loginBean) {
        registerIView.loginsucceed(loginBean);
    }

    @Override
    public void getLoginPost(String str) {
        registerIView.nothing(str);
    }

    @Override
    public void getphotoPost(String path) {
        Log.e("----------1111", "pppppppp");
        registerModel.getphotoPost(path, this);
    }

    @Override
    public void getphotoPost(photo photo) {
        registerIView.photosucceed(photo);
    }

    @Override
    public void getregisterPost(HashMap<String, Object> map) {
        registerModel.getregisPost(map, this);
    }

    @Override
    public void getregisterPost(register loginBean) {
        registerIView.registersucceed(loginBean);
    }


}
