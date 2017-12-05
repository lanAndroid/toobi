package com.toobi.toobi.utils.entry;

/**
 * Created by Rampant on 2017/11/6.
 */

public class creatRoom {


    /**
     * error_code : 200
     * msg : 创建话题房间成功
     * data : {"first_id":"101","room_id":"10"}
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
         * first_id : 101
         * room_id : 10
         */

        private String first_id;
        private String room_id;

        public String getFirst_id() {
            return first_id;
        }

        public void setFirst_id(String first_id) {
            this.first_id = first_id;
        }

        public String getRoom_id() {
            return room_id;
        }

        public void setRoom_id(String room_id) {
            this.room_id = room_id;
        }
    }
}
