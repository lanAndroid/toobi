package com.toobi.toobi.utils.entry;

import java.util.List;

/**
 * Created by Rampant on 2017/11/9.
 */

public class userInfo {

    /**
     * error_code : 200
     * msg : 鐢ㄦ埛璇︾粏鍜岀矇涓濆垪琛�
     * data : {"userInfo":{"avatar":"https://www.mini798.com/avatars/1510547218767.png","sex":"1","name":"瀹㈡湇","sign":"鍖栫畝涓虹箒","wangyi_account":"5ca850439a0e3a21c961779414d62129","is_follow":"1"},"fansList":[{"user_id":"1","wangyi_account":"5ca850439a0e3a21c961779414d62129","user_name":"瀹㈡湇","avatar":"https://www.mini798.com/avatars/1510547218767.png"},{"user_id":"13","wangyi_account":"df4ec03c82074e215e8e85ed53727da2","user_name":"娴嬭瘯","avatar":"https://www.mini798.com/avatars/1510456258974.png"},{"user_id":"4","wangyi_account":"e3e29adbd23b5fed5eff0f3855241e86","user_name":"12","avatar":"https://www.mini798.com/avatars/1510528863367.jpeg"},{"user_id":"4","wangyi_account":"e3e29adbd23b5fed5eff0f3855241e86","user_name":"12","avatar":"https://www.mini798.com/avatars/1510528863367.jpeg"}]}
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
         * userInfo : {"avatar":"https://www.mini798.com/avatars/1510547218767.png","sex":"1","name":"瀹㈡湇","sign":"鍖栫畝涓虹箒","wangyi_account":"5ca850439a0e3a21c961779414d62129","is_follow":"1"}
         * fansList : [{"user_id":"1","wangyi_account":"5ca850439a0e3a21c961779414d62129","user_name":"瀹㈡湇","avatar":"https://www.mini798.com/avatars/1510547218767.png"},{"user_id":"13","wangyi_account":"df4ec03c82074e215e8e85ed53727da2","user_name":"娴嬭瘯","avatar":"https://www.mini798.com/avatars/1510456258974.png"},{"user_id":"4","wangyi_account":"e3e29adbd23b5fed5eff0f3855241e86","user_name":"12","avatar":"https://www.mini798.com/avatars/1510528863367.jpeg"},{"user_id":"4","wangyi_account":"e3e29adbd23b5fed5eff0f3855241e86","user_name":"12","avatar":"https://www.mini798.com/avatars/1510528863367.jpeg"}]
         */

        private UserInfoBean userInfo;
        private List<FansListBean> fansList;

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        public List<FansListBean> getFansList() {
            return fansList;
        }

        public void setFansList(List<FansListBean> fansList) {
            this.fansList = fansList;
        }

        public static class UserInfoBean {
            /**
             * avatar : https://www.mini798.com/avatars/1510547218767.png
             * sex : 1
             * name : 瀹㈡湇
             * sign : 鍖栫畝涓虹箒
             * wangyi_account : 5ca850439a0e3a21c961779414d62129
             * is_follow : 1
             */

            private String avatar;
            private String sex;
            private String name;
            private String sign;
            private String wangyi_account;
            private String is_follow;

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

            public String getWangyi_account() {
                return wangyi_account;
            }

            public void setWangyi_account(String wangyi_account) {
                this.wangyi_account = wangyi_account;
            }

            public String getIs_follow() {
                return is_follow;
            }

            public void setIs_follow(String is_follow) {
                this.is_follow = is_follow;
            }
        }

        public static class FansListBean {
            /**
             * user_id : 1
             * wangyi_account : 5ca850439a0e3a21c961779414d62129
             * user_name : 瀹㈡湇
             * avatar : https://www.mini798.com/avatars/1510547218767.png
             */

            private String user_id;
            private String wangyi_account;
            private String user_name;
            private String avatar;

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

            public String getUser_name() {
                return user_name;
            }

            public void setUser_name(String user_name) {
                this.user_name = user_name;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }
        }
    }
}
