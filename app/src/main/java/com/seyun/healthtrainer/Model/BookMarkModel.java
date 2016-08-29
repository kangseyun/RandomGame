package com.seyun.healthtrainer.Model;

/**
 * Created by vcs-server on 8/15/16.
 */
public class BookMarkModel {
    private boolean check;
    private String name;
    public String getName() {
        return name;
    }

    public boolean getCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check == true ? false: true;
    }


    public BookMarkModel(boolean check, String name) {
        this.check = check;
        this.name = name;
    }
}
