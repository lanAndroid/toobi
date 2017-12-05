package com.toobi.toobi.ui.conversation.persenter;


import com.toobi.toobi.utils.entry.chatRoomList;
import com.toobi.toobi.utils.entry.fans;
import com.toobi.toobi.utils.entry.follow;

/**
 * Created by Rampant on 2017/11/8.
 */

public interface ConverPersenImpl {
    void  getfollow(String url);
    void  getfollow(follow follow);
    void  getfans(String url);
    void  getfans(fans fans);
    void  getchat(String url);
    void  getchat(chatRoomList fans);
}
