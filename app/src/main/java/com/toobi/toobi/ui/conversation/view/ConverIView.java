package com.toobi.toobi.ui.conversation.view;


import com.toobi.toobi.utils.entry.chatRoomList;
import com.toobi.toobi.utils.entry.fans;
import com.toobi.toobi.utils.entry.follow;

/**
 * Created by Rampant on 2017/11/8.
 */

public interface ConverIView {
    void getsuccend(follow follow);
    void getfanssuccend(fans fans);
    void getchatsuccend(chatRoomList fans);
}
