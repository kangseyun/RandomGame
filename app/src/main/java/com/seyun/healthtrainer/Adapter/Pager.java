package com.seyun.healthtrainer.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.seyun.healthtrainer.Fragment.First2Fragment;
import com.seyun.healthtrainer.Fragment.First3Fragment;
import com.seyun.healthtrainer.Fragment.FirstFragment;

public class Pager extends FragmentStatePagerAdapter {
    int tabCount;

    public Pager(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FirstFragment tab1 = new FirstFragment();
                Log.i("Click","1");
                return tab1;
            case 1:
                First2Fragment tab2 = new First2Fragment();
                Log.i("Click","2");
                return tab2;
            case 2:
                First3Fragment tab3 = new First3Fragment();
                Log.i("Click","2");
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
