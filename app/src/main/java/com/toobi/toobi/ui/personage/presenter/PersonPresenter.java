package com.toobi.toobi.ui.personage.presenter;


import com.toobi.toobi.ui.personage.model.PersonModel;
import com.toobi.toobi.ui.personage.view.PersonIView;
import com.toobi.toobi.utils.entry.LoginBean;
import com.toobi.toobi.utils.entry.fans;
import com.toobi.toobi.utils.entry.myRoom;
import com.toobi.toobi.utils.entry.suggest;
import com.toobi.toobi.utils.entry.userInfoUpdate;

import java.util.HashMap;

/**
 * Created by Rampant on 2017/11/8.
 */

public class PersonPresenter implements PersonPImpl {
    private PersonIView personIView;
    private PersonModel personModel;

    public PersonPresenter(PersonIView personIView) {
        this.personIView = personIView;
        personModel = new PersonModel();
    }

    @Override
    public void getuserInfoUpdatePOST(HashMap<String, String> map) {
        personModel.getuserInfoUpdate(map, this);
    }

    @Override
    public void getuserInfoUpdatePOST(userInfoUpdate userInfoUpdate) {
        personIView.Personsucceed(userInfoUpdate);
    }

    @Override
    public void getlogin(HashMap<String, String> map) {
        personModel.getlogin(map, this);
    }

    @Override
    public void getlogin(LoginBean loginBean) {
        personIView.login(loginBean);
    }

    @Override
    public void getsuggest(HashMap<String, String> map) {
        personModel.getsuggest(map, this);
    }

    @Override
    public void getsuggest(suggest suggest) {
        personIView.suggest(suggest);
    }

    @Override
    public void getfans(String url) {
        personModel.getfans(url, this);
    }

    @Override
    public void getfans(fans suggest) {
        personIView.fan(suggest);
    }

    @Override
    public void getmyroom(String url) {
        personModel.getmyroom(url, this);
    }

    @Override
    public void getmyroom(myRoom suggest) {
        personIView.myroom(suggest);
    }

    @Override
    public void nothing() {
        personIView.nothing();
    }
}
