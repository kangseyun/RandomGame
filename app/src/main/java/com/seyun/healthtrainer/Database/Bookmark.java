package com.seyun.healthtrainer.Database;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;

/**
 * Created by vcs-server on 8/19/16.
 */
public class Bookmark extends RealmObject {
    private String          title;

    public String getName() { return title; }
    public void   setName(String name) { this.title = name; }

}
