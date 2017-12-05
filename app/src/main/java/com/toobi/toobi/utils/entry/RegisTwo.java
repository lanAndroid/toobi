package com.toobi.toobi.utils.entry;

/**
 * Created by Rampant on 2017/11/1.
 */

public class RegisTwo {

    /**
     * error_code : 200
     * msg : 验证码通过
     * data : {"uptoken":"pybOSjMZdOHnJv5q3SVXmGHkDrI39SiXv_HSH2vj:wJV9wxbJjZy9buCHb_uIOAbmNxY=:eyJzY29wZSI6InRvb2JpIiwiZGVhZGxpbmUiOjE1MDk1MTgzNDR9"}
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
         * uptoken : pybOSjMZdOHnJv5q3SVXmGHkDrI39SiXv_HSH2vj:wJV9wxbJjZy9buCHb_uIOAbmNxY=:eyJzY29wZSI6InRvb2JpIiwiZGVhZGxpbmUiOjE1MDk1MTgzNDR9
         */

        private String uptoken;

        public String getUptoken() {
            return uptoken;
        }

        public void setUptoken(String uptoken) {
            this.uptoken = uptoken;
        }
    }
}
