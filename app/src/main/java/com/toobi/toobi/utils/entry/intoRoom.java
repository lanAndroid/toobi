package com.toobi.toobi.utils.entry;

/**
 * Created by Rampant on 2017/11/9.
 */

public class intoRoom {


    /**
     * error_code : 200
     * msg : 房间已经上锁,房间用户详细信息
     * data : {"is_lock":"2","avatar":"https://www.mini798.com/avatars/1510197416824.jpeg","sex":"2","name":"1","sign":"不想表达","is_follow":"2","is_follow_2":"2"}
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
         * is_lock : 2
         * avatar : https://www.mini798.com/avatars/1510197416824.jpeg
         * sex : 2
         * name : 1
         * sign : 不想表达
         * is_follow : 2
         * is_follow_2 : 2
         */

        private String is_lock;
        private String avatar;
        private String sex;
        private String name;
        private String sign;
        private String is_follow;
        private String is_follow_2;

        public String getIs_lock() {
            return is_lock;
        }

        public void setIs_lock(String is_lock) {
            this.is_lock = is_lock;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getIs_follow() {
            return is_follow;
        }

        public void setIs_follow(String is_follow) {
            this.is_follow = is_follow;
        }

        public String getIs_follow_2() {
            return is_follow_2;
        }

        public void setIs_follow_2(String is_follow_2) {
            this.is_follow_2 = is_follow_2;
        }
    }
}
