package com.toobi.toobi.ui.homepage.model;


import com.toobi.toobi.ui.homepage.persenter.HomePagerPersenter;

import java.util.HashMap;

/**
 * Created by Rampant on 2017/11/6.
 */

public interface HomePageModel {
    void HomepagerPost(HashMap<String, String> map, HomePagerPersenter homePager);

    void HomeRoomPost(String map, HomePagerPersenter homePager);

    void Homechatnum(HomePagerPersenter homePager);


}
