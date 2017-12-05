package com.toobi.toobi.utils.entry;

import java.util.List;

/**
 * Created by Rampant on 2017/11/9.
 */

public class chatRoomList {
    /**
     * error_code : 200
     * msg : 列表
     * data : [{"roomId":2,"chat_name":"Rrrr","user_id_1":1,"user_id_2":4,"wangyi_account_1":"5ca850439a0e3a21c961779414d62129","wangyi_account_2":"e3e29adbd23b5fed5eff0f3855241e86","avatar_1":"https://www.mini798.com/avatars/1509940380837.jpeg","avatar_2":"https://www.mini798.com/avatars/1510211414818.jpeg"},{"roomId":3,"chat_name":"测试试试","user_id_1":10,"user_id_2":1,"wangyi_account_1":"7f13f88d845851cc561ccb6fdf3ef1eb","wangyi_account_2":"5ca850439a0e3a21c961779414d62129","avatar_1":"https://www.mini798.com/avatar/52121234323246.jpg","avatar_2":"https://www.mini798.com/avatars/1509940380837.jpeg"},{"roomId":8,"chat_name":"下班不上班","user_id_1":4,"user_id_2":1,"wangyi_account_1":"e3e29adbd23b5fed5eff0f3855241e86","wangyi_account_2":"5ca850439a0e3a21c961779414d62129","avatar_1":"https://www.mini798.com/avatars/1510528863367.jpeg","avatar_2":"https://www.mini798.com/avatars/1510551347317.png"},{"roomId":10,"chat_name":"小伙伴想不到","user_id_1":15,"user_id_2":1,"wangyi_account_1":"124815913b2755a1963585f2905a49a5","wangyi_account_2":"5ca850439a0e3a21c961779414d62129","avatar_1":"https://www.mini798.com/avatars/1510555974463.jpeg","avatar_2":"https://www.mini798.com/avatars/1510551347317.png"},{"roomId":13,"chat_name":"非同凡响","user_id_1":1,"user_id_2":10,"wangyi_account_1":"5ca850439a0e3a21c961779414d62129","wangyi_account_2":"7f13f88d845851cc561ccb6fdf3ef1eb","avatar_1":"https://www.mini798.com/avatars/1510551347317.png","avatar_2":"https://www.mini798.com/avatars/1510558230786.jpeg"},{"roomId":14,"chat_name":"啊啊啊吧","user_id_1":1,"user_id_2":15,"wangyi_account_1":"5ca850439a0e3a21c961779414d62129","wangyi_account_2":"124815913b2755a1963585f2905a49a5","avatar_1":"https://www.mini798.com/avatars/1510551347317.png","avatar_2":"https://www.mini798.com/avatars/1510555974463.jpeg"},{"roomId":15,"chat_name":"gigogi","user_id_1":17,"user_id_2":1,"wangyi_account_1":"43a571820565ed4c76fa7d6f81d66970","wangyi_account_2":"5ca850439a0e3a21c961779414d62129","avatar_1":"https://www.mini798.com/avatars/1510631015761.jpeg","avatar_2":"https://www.mini798.com/avatars/1510551347317.png"},{"roomId":20,"chat_name":"野湖约架","user_id_1":1,"user_id_2":17,"wangyi_account_1":"5ca850439a0e3a21c961779414d62129","wangyi_account_2":"43a571820565ed4c76fa7d6f81d66970","avatar_1":"https://www.mini798.com/avatars/1510551347317.png","avatar_2":"https://www.mini798.com/avatars/1510631015761.jpeg"}]
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
         * roomId : 2
         * chat_name : Rrrr
         * user_id_1 : 1
         * user_id_2 : 4
         * wangyi_account_1 : 5ca850439a0e3a21c961779414d62129
         * wangyi_account_2 : e3e29adbd23b5fed5eff0f3855241e86
         * avatar_1 : https://www.mini798.com/avatars/1509940380837.jpeg
         * avatar_2 : https://www.mini798.com/avatars/1510211414818.jpeg
         */

        private int roomId;
        private String chat_name;
        private int user_id_1;
        private int user_id_2;
        private String wangyi_account_1;
        private String wangyi_account_2;
        private String avatar_1;
        private String avatar_2;

        public int getRoomId() {
            return roomId;
        }

        public void setRoomId(int roomId) {
            this.roomId = roomId;
        }

        public String getChat_name() {
            return chat_name;
        }

        public void setChat_name(String chat_name) {
            this.chat_name = chat_name;
        }

        public int getUser_id_1() {
            return user_id_1;
        }

        public void setUser_id_1(int user_id_1) {
            this.user_id_1 = user_id_1;
        }

        public int getUser_id_2() {
            return user_id_2;
        }

        public void setUser_id_2(int user_id_2) {
            this.user_id_2 = user_id_2;
        }

        public String getWangyi_account_1() {
            return wangyi_account_1;
        }

        public void setWangyi_account_1(String wangyi_account_1) {
            this.wangyi_account_1 = wangyi_account_1;
        }

        public String getWangyi_account_2() {
            return wangyi_account_2;
        }

        public void setWangyi_account_2(String wangyi_account_2) {
            this.wangyi_account_2 = wangyi_account_2;
        }

        public String getAvatar_1() {
            return avatar_1;
        }

        public void setAvatar_1(String avatar_1) {
            this.avatar_1 = avatar_1;
        }

        public String getAvatar_2() {
            return avatar_2;
        }

        public void setAvatar_2(String avatar_2) {
            this.avatar_2 = avatar_2;
        }
    }
}
