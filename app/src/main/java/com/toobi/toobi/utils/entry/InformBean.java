package com.toobi.toobi.utils.entry;

import java.util.List;

/**
 * Created by Rampant on 2017/11/3.
 */

public class InformBean {

    /**
     * error_code : 200
     * msg : 房间列表
     * data : {"first_id":"24","end_id":"2","roomList":[{"fid":"1","user_id":"5","wangyi_account":"adfdfxxsdkksfhsxxsees","is_lock":"0","room_name":"一路旅行","room_pic":"http:www/wwws/1.jpg"},{"fid":"12","user_id":"5","wangyi_account":"adfdfxxsdkksfhsxxsees","is_lock":"0","room_name":"一路旅行","room_pic":"http:www/wwws/1.jpg"}]}
     */

    private Long id;

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
         * end_id : 2
         * roomList : [{"fid":"1","user_id":"5","wangyi_account":"adfdfxxsdkksfhsxxsees","is_lock":"0","room_name":"一路旅行","room_pic":"http:www/wwws/1.jpg"},{"fid":"12","user_id":"5","wangyi_account":"adfdfxxsdkksfhsxxsees","is_lock":"0","room_name":"一路旅行","room_pic":"http:www/wwws/1.jpg"}]
         */

        private String first_id;
        private String end_id;
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

        public List<RoomListBean> getRoomList() {
            return roomList;
        }

        public void setRoomList(List<RoomListBean> roomList) {
            this.roomList = roomList;
        }

        public static class RoomListBean {
            public RoomListBean(String fid, String user_id, String wangyi_account, String is_lock, String room_name, String room_pic) {
                this.fid = fid;
                this.user_id = user_id;
                this.wangyi_account = wangyi_account;
                this.is_lock = is_lock;
                this.room_name = room_name;
                this.room_pic = room_pic;
            }

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
