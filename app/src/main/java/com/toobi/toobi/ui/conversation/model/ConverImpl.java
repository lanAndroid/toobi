package com.toobi.toobi.ui.conversation.model;

import com.toobi.toobi.ui.conversation.persenter.ConverPersenter;

/**
 * Created by Rampant on 2017/11/8.
 */

public interface ConverImpl {
    void  getfollow(String url, ConverPersenter converPersenter);
    void  getfans(String url, ConverPersenter converPersenter);
    void  getchat(String url, ConverPersenter converPersenter);
}
