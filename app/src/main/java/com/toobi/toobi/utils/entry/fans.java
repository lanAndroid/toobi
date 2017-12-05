package com.toobi.toobi.utils.entry;

import java.util.List;

/**
 * Created by Rampant on 2017/11/8.
 */

public class fans {
    /**
     * error_code : 200
     * msg : 用户详细和粉丝列表
     * data : {"fansList":[{"id":18,"uid":13,"wangyi_account":"df4ec03c82074e215e8e85ed53727da2","userName":"测试","avatar":"https://www.mini798.com/avatars/1510456258974.png"},{"id":14,"uid":1,"wangyi_account":"5ca850439a0e3a21c961779414d62129","userName":"客服","avatar":"https://www.mini798.com/avatars/1510547218767.png"},{"id":5,"uid":4,"wangyi_account":"e3e29adbd23b5fed5eff0f3855241e86","userName":"12","avatar":"https://www.mini798.com/avatars/1510528863367.jpeg"},{"id":4,"uid":4,"wangyi_account":"e3e29adbd23b5fed5eff0f3855241e86","userName":"12","avatar":"https://www.mini798.com/avatars/1510528863367.jpeg"}]}
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
        private List<FansListBean> fansList;

        public List<FansListBean> getFansList() {
            return fansList;
        }

        public void setFansList(List<FansListBean> fansList) {
            this.fansList = fansList;
        }

        public static class FansListBean {
            /**
             * id : 18
             * uid : 13
             * wangyi_account : df4ec03c82074e215e8e85ed53727da2
             * userName : 测试
             * avatar : https://www.mini798.com/avatars/1510456258974.png
             */

            private int id;
            private int uid;
            private String wangyi_account;
            private String userName;
            private String avatar;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public String getWangyi_account() {
                return wangyi_account;
            }

            public void setWangyi_account(String wangyi_account) {
                this.wangyi_account = wangyi_account;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
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
