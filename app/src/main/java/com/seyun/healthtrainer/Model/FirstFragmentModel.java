package com.seyun.healthtrainer.Model;

/**
 * Created by vcs-server on 8/15/16.
 */
public class FirstFragmentModel {
    private String title;
    private int img;
    public String getTitle() {
        return title;
    }

    public int getImg() {
        return img;
    }

    public FirstFragmentModel(String title, int img) {
        this.title = title;
        this.img = img;
    }
}
