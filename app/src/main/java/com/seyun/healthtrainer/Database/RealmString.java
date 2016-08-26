package com.seyun.healthtrainer.Database;

import io.realm.RealmObject;

/**
 * Created by vcs-server on 8/26/16.
 */
public class RealmString extends RealmObject {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
