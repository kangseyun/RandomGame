package com.seyun.healthtrainer.Database;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;

/**
 * Created by vcs-server on 8/19/16.
 */
public class User extends RealmObject {
    private String          name;
    RealmList<RealmString> names;

    public String getName() { return name; }
    public void   setName(String name) { this.name = name; }

}
