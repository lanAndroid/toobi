package com.toobi.toobi.utils.entry;

/**
 * Created by Rampant on 2017/11/11.
 */

public class personage {
    private String name;
    private String psw;


    public personage(String name, String psw) {
        this.name = name;
        this.psw = psw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }
}
