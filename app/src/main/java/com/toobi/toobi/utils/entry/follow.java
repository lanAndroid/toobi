package com.toobi.toobi.utils.entry;

import java.util.List;

/**
 * Created by Rampant on 2017/11/8.
 */

public class follow {

    /**
     * error_code : 200
     * msg : 关注列表
     * data : {"followList":[{"id":49,"uid":4,"wangyi_account":"e3e29adbd23b5fed5eff0f3855241e86","userName":"12","avatar":"https://www.mini798.com/avatars/1510528863367.jpeg"},{"id":48,"uid":4,"wangyi_account":"e3e29adbd23b5fed5eff0f3855241e86","userName":"12","avatar":"https://www.mini798.com/avatars/1510528863367.jpeg"},{"id":46,"uid":4,"wangyi_account":"e3e29adbd23b5fed5eff0f3855241e86","userName":"12","avatar":"https://www.mini798.com/avatars/1510528863367.jpeg"},{"id":45,"uid":18,"wangyi_account":"d8c5e8a4bea3a205ea41664fc3b1bbff","userName":"索马里","avatar":"http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTL4lvjiaWeM6dVFvlK3XYicaZW4AXwdacdh8Uy79UAibcJfs4PtHHrBfqEePJicicDhDicDxty5Hb79Ix3g/0"},{"id":6,"uid":2,"wangyi_account":"f27e05d64b7b21377fecfa516dfebb7c","userName":"1","avatar":"https://www.mini798.com/avatars/1510197416824.jpeg"}]}
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
        private List<FollowListBean> followList;

        public List<FollowListBean> getFollowList() {
            return followList;
        }

        public void setFollowList(List<FollowListBean> followList) {
            this.followList = followList;
        }

        public static class FollowListBean {
            /**
             * id : 49
             * uid : 4
             * wangyi_account : e3e29adbd23b5fed5eff0f3855241e86
             * userName : 12
             * avatar : https://www.mini798.com/avatars/1510528863367.jpeg
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
