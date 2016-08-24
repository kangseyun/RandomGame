package com.seyun.healthtrainer.Model;

/**
 * Created by vcs-server on 8/15/16.
 */
public class ContinueModel {
    private String title;
    private String sum1;
    private String sum2;

    public String getTitle() {
        return title;
    }

    public String getSum1() {
        return sum1;
    }
    public String getSum2() {
        return sum2;
    }

    public ContinueModel(String title, String sum1, String sum2) {
        this.title = title;
        this.sum1 = sum1;
        this.sum2 = sum2;
    }
}
