package com.toobi.toobi.utils.entry;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Rampant on 2017/11/6.
 */

public class roomSearch implements Serializable {

    /**
     * error_code : 200
     * msg : 搜索话题列表
     * data : [{"fid":3,"user_id":"6","wangyi_account":"124234234","is_lock":"1","room_name":"浙江游","room_pic":"http:www/wwws/2.jpg"},{"fid":2,"user_id":"4","wangyi_account":"124234234","is_lock":"0","room_name":"厦门游","room_pic":"www.www.22.jpg"},{"fid":1,"user_id":"5","wangyi_account":"sdfsdf234234","is_lock":"0","room_name":"云南游","room_pic":"http:www/wwws/2.jpg"}]
     */

    private String error_code;
    private String msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * fid : 3
         * user_id : 6
         * wangyi_account : 124234234
         * is_lock : 1
         * room_name : 浙江游
         * room_pic : http:www/wwws/2.jpg
         */

        private int fid;
        private String user_id;
        private String wangyi_account;
        private String is_lock;
        private String room_name;
        private String room_pic;

        public int getFid() {
            return fid;
        }

        public void setFid(int fid) {
            this.fid = fid;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getWangyi_account() {
            return wangyi_account;
        }

        public void setWangyi_account(String wangyi_account) {
            this.wangyi_account = wangyi_account;
        }

        public String getIs_lock() {
            return is_lock;
        }

        public void setIs_lock(String is_lock) {
            this.is_lock = is_lock;
        }

        public String getRoom_name() {
            return room_name;
        }

        public void setRoom_name(String room_name) {
            this.room_name = room_name;
        }

        public String getRoom_pic() {
            return room_pic;
        }

        public void setRoom_pic(String room_pic) {
            this.room_pic = room_pic;
        }
    }
}
