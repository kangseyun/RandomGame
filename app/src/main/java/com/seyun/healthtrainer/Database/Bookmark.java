package com.seyun.healthtrainer.Database;

import java.util.ArrayList;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;

/**
 * Created by vcs-server on 8/19/16.
 */
public class Bookmark extends RealmObject {
    private String          title;
    public RealmList<RealmString> name;

    public String getTitle() { return title; }
    public void   setTitle(String title) { this.title = title; }
}
