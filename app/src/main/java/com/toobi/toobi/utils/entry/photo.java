package com.toobi.toobi.utils.entry;

/**
 * Created by Rampant on 2017/11/2.
 */

public class photo {

    /**
     * error_code : 200
     * msg : 上传成功
     * data : {"avatar":"https: //www.mini798.com/avatar/52121234323246.jpg"}
     */

    private String error_code;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * avatar : https: //www.mini798.com/avatar/52121234323246.jpg
         */

        private String avatar;

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }
    }
}
