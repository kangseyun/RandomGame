package com.seyun.healthtrainer.Model;

/**
 * Created by vcs-server on 8/15/16.
 */
public class SelectMemberModel {
    private boolean check;
    private String name;
    public String getName() {
        return name;
    }

    public boolean getCheck() {
        return check;
    }

    public SelectMemberModel(boolean check, String name) {
        this.check = check;
        this.name = name;
    }
}
