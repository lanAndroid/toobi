package com.toobi.toobi.ui.conversation.persenter;

import com.toobi.toobi.ui.conversation.model.ConverModel;
import com.toobi.toobi.ui.conversation.persenter.ConverPersenImpl;
import com.toobi.toobi.ui.conversation.view.ConverIView;
import com.toobi.toobi.utils.entry.chatRoomList;
import com.toobi.toobi.utils.entry.fans;
import com.toobi.toobi.utils.entry.follow;


/**
 * Created by Rampant on 2017/11/8.
 */

public class ConverPersenter implements ConverPersenImpl {
    private ConverModel converModel;
    private ConverIView converIView;

    public ConverPersenter(ConverIView converIView) {
        this.converIView = converIView;
        converModel = new ConverModel();
    }

    @Override
    public void getfollow(String url) {
        converModel.getfollow(url, this);
    }

    @Override
    public void getfollow(follow follow) {
        converIView.getsuccend(follow);
    }

    @Override
    public void getfans(String url) {
        converModel.getfans(url, this);
    }

    @Override
    public void getfans(fans fans) {
        converIView.getfanssuccend(fans);
    }

    @Override
    public void getchat(String url) {
        converModel.getchat(url, this);
    }

    @Override
    public void getchat(chatRoomList fans) {
        converIView.getchatsuccend(fans);
    }
}
