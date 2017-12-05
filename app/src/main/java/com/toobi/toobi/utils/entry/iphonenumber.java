package com.toobi.toobi.utils.entry;

import java.util.List;

/**
 * Created by Rampant on 2017/11/1.
 */

public class iphonenumber {

    /**
     * error_code : 200
     * msg : 发送成功
     * data : []
     */

    private String error_code;
    private String msg;
    private List<?> data;

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
