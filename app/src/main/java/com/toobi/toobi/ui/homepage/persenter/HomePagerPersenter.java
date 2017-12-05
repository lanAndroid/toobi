package com.toobi.toobi.ui.homepage.persenter;


import android.util.Log;

import com.toobi.toobi.ui.homepage.model.HomepagerImpl;
import com.toobi.toobi.ui.homepage.view.HomePagerIView;
import com.toobi.toobi.utils.entry.chatNum;
import com.toobi.toobi.utils.entry.creatRoom;
import com.toobi.toobi.utils.entry.roomSearch;

import java.util.HashMap;

/**
 * Created by Rampant on 2017/11/6.
 */

public class HomePagerPersenter implements HomePagerImpl {
    private HomePagerIView homePagerIView;
    private HomepagerImpl homepager;

    public HomePagerPersenter(HomePagerIView homePagerIView) {
        this.homePagerIView = homePagerIView;
        homepager = new HomepagerImpl();
    }

    @Override
    public void HomePagerPOST(HashMap<String, String> map) {
        homepager.HomepagerPost(map, this);
    }

    @Override
    public void HomePagerPOST(creatRoom creatRoom) {
        homePagerIView.Homepagersucceed(creatRoom);
    }

    @Override
    public void HomeRoomPOST(String map) {
        homepager.HomeRoomPost(map, this);
    }

    @Override
    public void HomeRoomPOST(roomSearch roomSearch) {
        homePagerIView.HomeRoomsucceed(roomSearch);
    }

    @Override
    public void Homechatnum(chatNum chatNum) {
        homePagerIView.Homechatsucceed(chatNum);
    }

    @Override
    public void Homechatnum() {
        homepager.Homechatnum(this);
    }
}
