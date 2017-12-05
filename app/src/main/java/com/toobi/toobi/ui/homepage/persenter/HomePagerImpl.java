package com.toobi.toobi.ui.homepage.persenter;


import com.toobi.toobi.utils.entry.chatNum;
import com.toobi.toobi.utils.entry.creatRoom;
import com.toobi.toobi.utils.entry.roomSearch;

import java.util.HashMap;

/**
 * Created by Rampant on 2017/11/6.
 */

public interface HomePagerImpl {
    void HomePagerPOST(HashMap<String, String> map);
    void HomePagerPOST(creatRoom creatRoom);
    void HomeRoomPOST(String map);
    void HomeRoomPOST(roomSearch roomSearch);
    void Homechatnum(chatNum chatNum);
    void Homechatnum();
}
