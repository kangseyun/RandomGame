package com.seyun.healthtrainer.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.seyun.healthtrainer.Adapter.Pager;
import com.seyun.healthtrainer.Model.SelectMemberModel;
import com.seyun.healthtrainer.R;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener, ViewPager.OnPageChangeListener{
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TextView title;
    private FloatingActionButton fab, fab2, fab3;
    private CoordinatorLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    void init() {
        layout = (CoordinatorLayout) findViewById(R.id.main_layout);
        tabLayoutBind();
        tabBind();
        setViewPager();
        floatingButtonBind();
        fabBind();
    }

    void tabBind() {
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        setupTabs();
        tabLayout.setOnTabSelectedListener(this);
    }

    private void setViewPager() {
        viewPager = (ViewPager) findViewById(R.id.pager);
        Pager adapter = new Pager(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setOnPageChangeListener(this);
        viewPager.setAdapter(adapter);
    }

    private void tabLayoutBind() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle();
    }

    private void setTitle() {
        Intent i = getIntent();
        String get_title = i.getExtras().getString("title");
        title = (TextView) findViewById(R.id.toolbar_title);
        title.setText(get_title);
    }

    private void setupTabs() {
        // Title Setup
        tabLayout.addTab(tabLayout.newTab().setText("게임"));
        tabLayout.addTab(tabLayout.newTab().setText("통계"));
        tabLayout.addTab(tabLayout.newTab().setText("계산"));

        // Icon Setup
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_games_white_36dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_timeline_white_36dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_account_balance_wallet_white_36dp);

    }

    private void fabBind() {
        // fab Bind
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab3 = (FloatingActionButton) findViewById(R.id.fab3);
    }


    private List<SelectMemberModel> getUserInformation() {

        List<SelectMemberModel> userList = new ArrayList<>();
        userList.add(new SelectMemberModel(false,"123"));
        return userList;
    }

    private void floatingButtonBind() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        FloatingActionButton fab3 = (FloatingActionButton) findViewById(R.id.fab3);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean wrapInScrollView = true;
                new MaterialDialog.Builder(view.getContext())
                        .title("123")
                        .customView(R.layout.fragment_first, wrapInScrollView)
                        .positiveText("123")
                        .show();
                Snackbar.make(layout, "Hello World", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
        animateFab(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private void animateFab(int position) {
        switch (position) {
            case 0:
                fab.show();
                fab2.hide();
                fab3.hide();
                break;
            case 1:
                fab.hide();
                fab2.hide();
                fab3.hide();
                break;
            case 2:
                fab3.show();
                fab.hide();
                fab2.hide();
                break;
            default:
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }
    @Override
    public void onPageSelected(int position) {
        animateFab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}