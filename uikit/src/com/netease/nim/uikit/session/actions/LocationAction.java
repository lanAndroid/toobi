package com.netease.nim.uikit.session.actions;

import android.content.Context;
import android.util.Log;

import com.netease.nim.uikit.plugin.LocationProvider;
import com.netease.nim.uikit.core.NimUIKitImpl;
import com.netease.nim.uikit.R;
import com.netease.nimlib.sdk.msg.MessageBuilder;
import com.netease.nimlib.sdk.msg.model.IMMessage;

/**
 * Created by hzxuwen on 2015/6/12.
 */
public class LocationAction extends BaseAction {
    private final static String TAG = "LocationAction";

    public LocationAction() {
        super(R.drawable.nim_message_plus_location_selector, R.string.input_panel_location);
    }

    @Override
    public void onClick() {
        Log.e(TAG, "点击");
        Log.e(TAG, "点击"+NimUIKitImpl.getLocationProvider());
        if (NimUIKitImpl.getLocationProvider() != null) {
            NimUIKitImpl.getLocationProvider().requestLocation(getActivity(), new LocationProvider.Callback() {
                @Override
                public void onSuccess(double longitude, double latitude, String address) {
                    IMMessage message = MessageBuilder.createLocationMessage(getAccount(), getSessionType(), latitude, longitude,
                            address);
                    sendMessage(message);
                }
            });
        }
    }
}
