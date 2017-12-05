package com.toobi.toobi.ui.homepage.view;


import com.toobi.toobi.utils.entry.chatNum;
import com.toobi.toobi.utils.entry.creatRoom;
import com.toobi.toobi.utils.entry.roomSearch;

/**
 * Created by Rampant on 2017/11/6.
 */

public interface HomePagerIView  {
    void Homepagersucceed(creatRoom creatRoom);
    void HomeRoomsucceed(roomSearch roomSearch);
    void Homechatsucceed(chatNum chatNum);
    // 失败
    void nothing(String nothing);
}
