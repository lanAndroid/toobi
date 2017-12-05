package com.toobi.toobi.utils.entry;

import java.util.List;

/**
 * Created by Rampant on 2017/11/2.
 */

public class register {

    /**
     * error_code : 200
     * msg : 注册成功
     * data : {"first_id":"7","end_id":"2","userInfo":{"wangyi_appkey":"57c80ab6c6019dd4a9b2d4a7036b9fec","wangyi_account":"6b545a6000f615b38d154c7fb4a1207a","wangyi_token":"4ce93264b2f6f9db756e615920ec13d3","user_id":"14","avatar":"http://img4.imgtn.214&gp=0.jpg","sex":"1","name":"test4","sign":"sdfsdf水电费是否"},"roomList":[{"fid":"1","user_id":"5","wangyi_account":"adfdfxxsdkksfhsxxsees","is_lock":"0","room_name":"一路旅行","room_pic":"http:www/wwws/1.jpg"},{"fid":"2","user_id":"5","wangyi_account":"adfdfxxsdkksfhsxxsees","is_lock":"0","room_name":"一路旅行","room_pic":"http:www/wwws/1.jpg"}]}
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
         * first_id : 7
         * end_id : 2
         * userInfo : {"wangyi_appkey":"57c80ab6c6019dd4a9b2d4a7036b9fec","wangyi_account":"6b545a6000f615b38d154c7fb4a1207a","wangyi_token":"4ce93264b2f6f9db756e615920ec13d3","user_id":"14","avatar":"http://img4.imgtn.214&gp=0.jpg","sex":"1","name":"test4","sign":"sdfsdf水电费是否"}
         * roomList : [{"fid":"1","user_id":"5","wangyi_account":"adfdfxxsdkksfhsxxsees","is_lock":"0","room_name":"一路旅行","room_pic":"http:www/wwws/1.jpg"},{"fid":"2","user_id":"5","wangyi_account":"adfdfxxsdkksfhsxxsees","is_lock":"0","room_name":"一路旅行","room_pic":"http:www/wwws/1.jpg"}]
         */

        private String first_id;
        private String end_id;
        private UserInfoBean userInfo;
        private List<RoomListBean> roomList;

        public String getFirst_id() {
            return first_id;
        }

        public void setFirst_id(String first_id) {
            this.first_id = first_id;
        }

        public String getEnd_id() {
            return end_id;
        }

        public void setEnd_id(String end_id) {
            this.end_id = end_id;
        }

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        public List<RoomListBean> getRoomList() {
            return roomList;
        }

        public void setRoomList(List<RoomListBean> roomList) {
            this.roomList = roomList;
        }

        public static class UserInfoBean {
            /**
             * wangyi_appkey : 57c80ab6c6019dd4a9b2d4a7036b9fec
             * wangyi_account : 6b545a6000f615b38d154c7fb4a1207a
             * wangyi_token : 4ce93264b2f6f9db756e615920ec13d3
             * user_id : 14
             * avatar : http://img4.imgtn.214&gp=0.jpg
             * sex : 1
             * name : test4
             * sign : sdfsdf水电费是否
             */

            private String wangyi_appkey;
            private String wangyi_account;
            private String wangyi_token;
            private String user_id;
            private String avatar;
            private String sex;
            private String name;
            private String sign;

            public String getWangyi_appkey() {
                return wangyi_appkey;
            }

            public void setWangyi_appkey(String wangyi_appkey) {
                this.wangyi_appkey = wangyi_appkey;
            }

            public String getWangyi_account() {
                return wangyi_account;
            }

            public void setWangyi_account(String wangyi_account) {
                this.wangyi_account = wangyi_account;
            }

            public String getWangyi_token() {
                return wangyi_token;
            }

            public void setWangyi_token(String wangyi_token) {
                this.wangyi_token = wangyi_token;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
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
        }

        public static class RoomListBean {
            /**
             * fid : 1
             * user_id : 5
             * wangyi_account : adfdfxxsdkksfhsxxsees
             * is_lock : 0
             * room_name : 一路旅行
             * room_pic : http:www/wwws/1.jpg
             */

            private String fid;
            private String user_id;
            private String wangyi_account;
            private String is_lock;
            private String room_name;
            private String room_pic;

            public String getFid() {
                return fid;
            }

            public void setFid(String fid) {
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
}
