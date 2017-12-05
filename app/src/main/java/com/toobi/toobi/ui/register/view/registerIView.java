package com.toobi.toobi.ui.register.view;


import com.toobi.toobi.utils.entry.LoginBean;
import com.toobi.toobi.utils.entry.RegisTwo;
import com.toobi.toobi.utils.entry.backpassword;
import com.toobi.toobi.utils.entry.iphonenumber;
import com.toobi.toobi.utils.entry.photo;
import com.toobi.toobi.utils.entry.register;

/**
 * Created by Rampant on 2017/11/1.
 */

public interface registerIView {
    // 成功
    void Regissucceed(iphonenumber iphonenumber);

    void RegisTwosucceed(RegisTwo regisTwo);

    void backposswordsucceed(backpassword backpassword);

    void loginsucceed(LoginBean loginBean);

    void photosucceed(photo photo);

    void registersucceed(register register);

    // 失败
    void nothing(String nothing);
}
