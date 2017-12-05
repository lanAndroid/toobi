package com.toobi.toobi.ui.personage.model;



import com.toobi.toobi.ui.personage.presenter.PersonPresenter;

import java.util.HashMap;

/**
 * Created by Rampant on 2017/11/8.
 */

public interface PersonImpl {
    void getuserInfoUpdate(HashMap<String, String> map, PersonPresenter personPresenter);
    void getlogin(HashMap<String, String> map, PersonPresenter personPresenter);
    void getsuggest(HashMap<String, String> map, PersonPresenter personPresenter);
    void getfans(String url, PersonPresenter personPresenter);
    void getmyroom(String url, PersonPresenter personPresenter);

}
