package com.seyun.healthtrainer.Model;

/**
 * Created by vcs-server on 8/15/16.
 */
public class Fragment3Model {
    private String name;
    private String sum1;
    private String sum2;

    public String getName() {
        return name;
    }

    public String getSum1() {
        return sum1;
    }
    public String getSum2() {
        return sum2;
    }

    public Fragment3Model(String name, String sum1, String sum2) {
        this.name = name;
        this.sum1 = sum1;
        this.sum2 = sum2;
    }
}
