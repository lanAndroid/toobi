package com.toobi.toobi.ui.information.view;

import com.netease.nimlib.sdk.msg.attachment.MsgAttachment;
import com.netease.nimlib.sdk.msg.model.IMMessage;

import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by Rampant on 2017/11/14.
 */

public abstract class CustomAttachment implements MsgAttachment {
    protected int type;

    public CustomAttachment(int type) {
        this.type = type;
    }

    public void fromJson(com.alibaba.fastjson.JSONObject data) {
        if (data != null) {
            parseData(data);
        }
    }

    @Override
    public String toJson(boolean send) {
        return CustomAttachParser.packData(type, packData());
    }

    public int getType() {
        return type;
    }

    protected abstract void parseData(com.alibaba.fastjson.JSONObject data);
    protected abstract com.alibaba.fastjson.JSONObject packData();


}
