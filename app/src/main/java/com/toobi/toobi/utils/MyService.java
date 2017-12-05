package com.toobi.toobi.utils;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.msg.MsgService;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by vicky on 2015/8/5.
 */

public class MyService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();

        //定时器每隔1秒发送一次广播
        new Timer().scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                int unreadNum = NIMClient.getService(MsgService.class).getTotalUnreadCount();
                Intent timeIntent = new Intent();
                timeIntent.putExtra("num", unreadNum);
                timeIntent.setAction("TIME_CHANGED_ACTION");//自定义Action
                sendBroadcast(timeIntent); //发送广播
            }
        }, 0, 1000);
        { //每隔1秒
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
