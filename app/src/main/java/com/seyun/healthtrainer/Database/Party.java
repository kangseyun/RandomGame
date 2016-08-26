package com.seyun.healthtrainer.Database;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by vcs-server on 8/19/16.
 */
public class Party extends RealmObject {
    private String              title;
    public RealmList<Bookmark>  name;

    public String getTitle() { return title; }
    public void   setTitle(String title) { this.title = title; }


}
