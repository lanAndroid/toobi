package com.toobi.toobi.wxapi.presenter;

import com.toobi.toobi.ui.register.view.registerIView;
import com.toobi.toobi.utils.entry.LoginBean;
import com.toobi.toobi.wxapi.model.Model;
import com.toobi.toobi.wxapi.wxIview;

import java.util.HashMap;

/**
 * Created by Rampant on 2017/11/1.
 */

public class wxpreIMpl implements wxpresenter {
    private wxIview registerIView;
    private Model Model;

    public wxpreIMpl(wxIview registerIView) {
        this.registerIView = registerIView;
        Model = new Model();
    }


    @Override
    public void getLoginPost(HashMap<String, String> map) {
        Model.getLoginPost(map, this);
    }

    @Override
    public void getlloginno(String str) {
        registerIView.nothing();
    }

    @Override
    public void getLoginPost(LoginBean loginBean) {
        registerIView.sunccess(loginBean);
    }

}
