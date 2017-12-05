package com.toobi.toobi.utils.entry;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Rampant on 2017/11/1.
 */

public class LoginBean implements Serializable {

    /**
     * error_code : 200
     * msg : 登录成功
     * data : {"first_id":"24","end_id":"11","num":"580","userInfo":{"wangyi_appkey":"57c80ab6c6019dd4a9b2d4a7036b9fec","wangyi_account":"aa2c6c54274850023fb69965fa5ef051","wangyi_token":"804710eff4dc4a767166e5485bd27832","user_access_token":"A1UAxWDdVqKb5lf4b+5YOCQlNg45nnq+497OSb6v+GrLL9tplD2oEyO2tyG+wPyg","user_id":"2","avatar":"https://www.mini798.com/avatars/1508405776.png","age":18,"sex":"1","name":"test4","sign":"不想表达","login_type":"1"},"roomList":[{"fid":24,"user_id":"9","wangyi_account":"1eaf2d23c6a7b8e62d6d13c835f2dc44","is_lock":"0","room_name":"124次","room_pic":"https://www.mini798.com/avatars/1509335086724.jpeg"},{"fid":22,"user_id":"9","wangyi_account":"1eaf2d23c6a7b8e62d6d13c835f2dc44","is_lock":"0","room_name":"124次","room_pic":"https://www.mini798.com/avatars/1509335086724.jpeg"},{"fid":21,"user_id":"9","wangyi_account":"1eaf2d23c6a7b8e62d6d13c835f2dc44","is_lock":"0","room_name":"124次","room_pic":"https://www.mini798.com/avatars/1509335086724.jpeg"},{"fid":20,"user_id":"9","wangyi_account":"1eaf2d23c6a7b8e62d6d13c835f2dc44","is_lock":"0","room_name":"124次","room_pic":"https://www.mini798.com/avatars/1509335086724.jpeg"},{"fid":19,"user_id":"8","wangyi_account":"6adec00db2cc1876832df406b94527fc","is_lock":"0","room_name":"告别尬聊","room_pic":"https://www.mini798.com/avatars/1509182332409.jpeg"},{"fid":18,"user_id":"3","wangyi_account":"4e4e307833175717ed34a6adc4ac1e87","is_lock":"0","room_name":"测试high","room_pic":"https://www.mini798.com/avatars/1508405776.png"}]}
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
         * first_id : 24
         * end_id : 11
         * num : 580
         * userInfo : {"wangyi_appkey":"57c80ab6c6019dd4a9b2d4a7036b9fec","wangyi_account":"aa2c6c54274850023fb69965fa5ef051","wangyi_token":"804710eff4dc4a767166e5485bd27832","user_access_token":"A1UAxWDdVqKb5lf4b+5YOCQlNg45nnq+497OSb6v+GrLL9tplD2oEyO2tyG+wPyg","user_id":"2","avatar":"https://www.mini798.com/avatars/1508405776.png","age":18,"sex":"1","name":"test4","sign":"不想表达","login_type":"1"}
         * roomList : [{"fid":24,"user_id":"9","wangyi_account":"1eaf2d23c6a7b8e62d6d13c835f2dc44","is_lock":"0","room_name":"124次","room_pic":"https://www.mini798.com/avatars/1509335086724.jpeg"},{"fid":22,"user_id":"9","wangyi_account":"1eaf2d23c6a7b8e62d6d13c835f2dc44","is_lock":"0","room_name":"124次","room_pic":"https://www.mini798.com/avatars/1509335086724.jpeg"},{"fid":21,"user_id":"9","wangyi_account":"1eaf2d23c6a7b8e62d6d13c835f2dc44","is_lock":"0","room_name":"124次","room_pic":"https://www.mini798.com/avatars/1509335086724.jpeg"},{"fid":20,"user_id":"9","wangyi_account":"1eaf2d23c6a7b8e62d6d13c835f2dc44","is_lock":"0","room_name":"124次","room_pic":"https://www.mini798.com/avatars/1509335086724.jpeg"},{"fid":19,"user_id":"8","wangyi_account":"6adec00db2cc1876832df406b94527fc","is_lock":"0","room_name":"告别尬聊","room_pic":"https://www.mini798.com/avatars/1509182332409.jpeg"},{"fid":18,"user_id":"3","wangyi_account":"4e4e307833175717ed34a6adc4ac1e87","is_lock":"0","room_name":"测试high","room_pic":"https://www.mini798.com/avatars/1508405776.png"}]
         */

        private String first_id;
        private String end_id;
        private String num;
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

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
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
             * wangyi_account : aa2c6c54274850023fb69965fa5ef051
             * wangyi_token : 804710eff4dc4a767166e5485bd27832
             * user_access_token : A1UAxWDdVqKb5lf4b+5YOCQlNg45nnq+497OSb6v+GrLL9tplD2oEyO2tyG+wPyg
             * user_id : 2
             * avatar : https://www.mini798.com/avatars/1508405776.png
             * age : 18
             * sex : 1
             * name : test4
             * sign : 不想表达
             * login_type : 1
             */

            private String wangyi_appkey;
            private String wangyi_account;
            private String wangyi_token;
            private String user_access_token;
            private String user_id;
            private String avatar;
            private int age;
            private String sex;
            private String name;
            private String sign;
            private String login_type;

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

            public String getUser_access_token() {
                return user_access_token;
            }

            public void setUser_access_token(String user_access_token) {
                this.user_access_token = user_access_token;
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

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
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

            public String getLogin_type() {
                return login_type;
            }

            public void setLogin_type(String login_type) {
                this.login_type = login_type;
            }
        }

        public static class RoomListBean {
            /**
             * fid : 24
             * user_id : 9
             * wangyi_account : 1eaf2d23c6a7b8e62d6d13c835f2dc44
             * is_lock : 0
             * room_name : 124次
             * room_pic : https://www.mini798.com/avatars/1509335086724.jpeg
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
}
