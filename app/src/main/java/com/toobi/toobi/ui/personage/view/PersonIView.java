package com.toobi.toobi.ui.personage.view;


import com.toobi.toobi.utils.entry.LoginBean;
import com.toobi.toobi.utils.entry.fans;
import com.toobi.toobi.utils.entry.myRoom;
import com.toobi.toobi.utils.entry.suggest;
import com.toobi.toobi.utils.entry.userInfoUpdate;

/**
 * Created by Rampant on 2017/11/8.
 */

public interface PersonIView {
    void Personsucceed(userInfoUpdate userInfoUpdate);

    void login(LoginBean loginBean);

    void suggest(suggest loginBean);

    void myroom(myRoom loginBean);

    void fan(fans loginBean);

    void nothing();
}
